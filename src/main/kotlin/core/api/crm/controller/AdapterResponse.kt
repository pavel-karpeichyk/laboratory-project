package core.api.crm.controller

import okhttp3.Response

class AdapterResponse() {

  fun <T : Any?> adeptToOkHttpResponse(retrofitResponse: retrofit2.Response<T>): Response = retrofitResponse.raw()
}