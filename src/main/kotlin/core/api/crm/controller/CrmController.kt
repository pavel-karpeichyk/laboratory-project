package core.api.crm.controller

import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.retrofit.client.RetrofitClient.getRetrofitClient
import core.api.crm.service.CrmAuthService
import core.holder.StaticContextHolder.getConfig
import retrofit2.Response

class CrmController {

  private val baseUrl = getConfig().getBaseUrl()
  private val userCMR: CrmUserRequest = CrmUserRequest(
    getConfig().cmrUserConfig.login,
    getConfig().cmrUserConfig.password,
    getConfig().cmrUserConfig.captcha
  )

  fun authCrm(): okhttp3.Response {
    val service: CrmAuthService = getRetrofitClient(baseUrl)?.create(CrmAuthService::class.java)!!
    val retrofitResponse: Response<CrmUserResponse> = service.singInUser(userCMR)
    return AdapterResponse().adeptToOkHttpResponse(retrofitResponse)
  }
}