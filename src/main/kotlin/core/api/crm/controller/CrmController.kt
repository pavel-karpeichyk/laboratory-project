package core.api.crm.controller

import core.api.HTTPclient.TafResponse
import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.retrofit.client.RetrofitClient.getRetrofitClient
import core.api.crm.service.CrmAuthService
import core.holder.StaticContextHolder.getConfig
import retrofit2.Call
import retrofit2.Response

class CrmController {

  private val baseUrl = getConfig().getBaseUrl()
  private val userCRM: CrmUserRequest = with(getConfig().cmrUserConfig) {
    CrmUserRequest(login, password, captcha)
  }
  private val service: CrmAuthService = getRetrofitClient(baseUrl)?.create(CrmAuthService::class.java)!!

  fun authCrm(): TafResponse {
    val callSync: Call<CrmUserResponse> = service.singInUser(userCRM)
    val retrofitResponse: Response<CrmUserResponse> = callSync.execute()
    return TafResponse(retrofitResponse.raw())
  }
}