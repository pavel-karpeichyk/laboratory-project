package core.api.crm.controller

import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmAuthService
import core.context.dynamicContext
import core.context.staticContext
import core.http.response.TafResponse
import core.http.retrofit.RetrofitClient.getRetrofitClient
import retrofit2.Call
import retrofit2.Response

class CrmController {

  private val baseUrl = staticContext.getBaseUrl()
  private val userCRM: CrmUserRequest = with(staticContext.cmrUserConfig) {
    CrmUserRequest(login, password, captcha)
  }
  private val service: CrmAuthService = getRetrofitClient(baseUrl).create(CrmAuthService::class.java)

  fun authCrm(): TafResponse {
    val callSync: Call<CrmUserResponse> = service.singInUser(userCRM)
    val retrofitResponse: Response<CrmUserResponse> = callSync.execute()
    val tafResponse: TafResponse = TafResponse(retrofitResponse.raw())
    dynamicContext.sessionContext.serviceResponse = tafResponse

    return tafResponse
  }
}