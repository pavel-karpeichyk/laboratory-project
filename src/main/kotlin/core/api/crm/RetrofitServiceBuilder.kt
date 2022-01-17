package core.api.crm

import core.api.crm.service.CrmAuthService
import core.http.retrofit.RetrofitClient

class RetrofitServiceBuilder(var baseUrl: String) {

  fun buildService(service: Class<CrmAuthService>): CrmAuthService {
    return RetrofitClient.getRetrofitClient(baseUrl).create(service)
  }
}