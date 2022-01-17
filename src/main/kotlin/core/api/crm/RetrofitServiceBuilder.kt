package core.api.crm

import core.http.retrofit.RetrofitClient

class RetrofitServiceBuilder(var baseUrl: String) {

  fun <T> buildService(service: Class<T>): T {
    return RetrofitClient.getRetrofitClient(baseUrl).create(service)
  }
}