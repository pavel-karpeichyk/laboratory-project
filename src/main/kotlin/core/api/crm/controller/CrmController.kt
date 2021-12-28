package core.api.crm.controller

import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.retrofit.client.RetrofitClient.getRetrofitClient
import core.api.crm.service.CrmAuthService
import core.api.http.TafResponse
import core.application.app_config.model.AppConfig
import core.holder.dynamic_context_holder.DynamicContext
import core.holder.dynamic_context_holder.DynamicContextHolder
import core.holder.static_context_holder.StaticContextHolder.getContext
import retrofit2.Call
import retrofit2.Response

class CrmController {

  private val baseUrl = getContext<AppConfig>().getBaseUrl()
  private val userCRM: CrmUserRequest = with(getContext<AppConfig>().cmrUserConfig) {
    CrmUserRequest(login, password, captcha)
  }
  private val service: CrmAuthService = getRetrofitClient(baseUrl)?.create(CrmAuthService::class.java)!!

  fun authCrm(): TafResponse {
    val callSync: Call<CrmUserResponse> = service.singInUser(userCRM)
    val retrofitResponse: Response<CrmUserResponse> = callSync.execute()
    val tafResponse: TafResponse = TafResponse(retrofitResponse.raw())
    DynamicContextHolder.getContext<DynamicContext>().sessionContext.serviceResponse = tafResponse
    return tafResponse
  }
}