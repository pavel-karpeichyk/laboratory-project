package core.api.crm.controller

import core.api.crm.CrmRequestBuilder
import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmAuthService
import core.context.serviceResponse
import core.context.staticContext
import core.http.response.TafResponse
import core.http.retrofit.RetrofitClient.getRetrofitClient
import retrofit2.Call
import retrofit2.Response

class CrmController(
  private val baseUrl: String = staticContext.getBaseUrl(),
  private val service: CrmAuthService = getRetrofitClient(baseUrl).create(CrmAuthService::class.java),
  private val requestBuilder: CrmRequestBuilder = CrmRequestBuilder()
) {

  private val userCRM: CrmUserRequest = requestBuilder.getAuthRequest()

  fun authCrm(): TafResponse {
    val callSync: Call<CrmUserResponse> = service.singInUser(userCRM)
    val retrofitResponse: Response<CrmUserResponse> = callSync.execute()
    val tafResponse: TafResponse = TafResponse(retrofitResponse.raw())
    serviceResponse = tafResponse
    return tafResponse
  }
}