package core.api.crm.controller

import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmAuthService
import core.api.http.TafResponse
import core.api.retrofit.client.RetrofitClient.getRetrofitClient
import core.holder.dynamicContext
import core.holder.staticContext
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