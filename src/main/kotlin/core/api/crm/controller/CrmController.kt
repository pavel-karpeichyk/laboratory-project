package core.api.crm.controller

import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmAuthService
import core.context.crmUserConfig
import core.context.serviceResponse
import core.context.staticContext
import core.http.response.TafResponse
import core.http.retrofit.RetrofitClient.getRetrofitClient
import retrofit2.Call
import retrofit2.Response

class CrmController() {

  private var baseUrl = staticContext.getBaseUrl()
  private val userCRM: CrmUserRequest = with(crmUserConfig) {
    CrmUserRequest(login, password, captcha)
  }

  fun authCrm(crmUrl: String = baseUrl): TafResponse {
    val service: CrmAuthService = getRetrofitClient(crmUrl).create(CrmAuthService::class.java)
    val callSync: Call<CrmUserResponse> = service.singInUser(userCRM)
    val retrofitResponse: Response<CrmUserResponse> = callSync.execute()
    val tafResponse: TafResponse = TafResponse(retrofitResponse.raw())
    serviceResponse = tafResponse

    return tafResponse
  }
}