package core.api.crm.controller

import core.api.crm.CrmRequestBuilder
import core.api.crm.RetrofitServiceBuilder
import core.api.crm.model.CrmUserRequest
import core.api.crm.service.CrmAuthService
import core.context.serviceResponse
import core.context.staticContext
import core.http.response.TafResponse

class CrmController(
  private val baseUrl: String = staticContext.getBaseUrl(),
  private val service: CrmAuthService = RetrofitServiceBuilder(baseUrl).buildService(CrmAuthService::class.java),
  private val requestBuilder: CrmRequestBuilder = CrmRequestBuilder(),

  ) {

  fun authCrm(): TafResponse {
    val crmUserRequest: CrmUserRequest = requestBuilder.getCrmUserRequest()
    return TafResponse(service.singInUser(crmUserRequest).execute().raw()).also { serviceResponse = it }
  }
}