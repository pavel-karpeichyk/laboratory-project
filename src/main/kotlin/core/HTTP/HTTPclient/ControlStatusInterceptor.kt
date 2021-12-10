package core.HTTP.HTTPclient

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ControlStatusInterceptor : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response = chain.proceed(request)
    val statusCode: Int = response.code
    if (!(statusCode == 200 || statusCode == 201)) throw Exception("Unexpected code : $statusCode")
    return response
  }
}