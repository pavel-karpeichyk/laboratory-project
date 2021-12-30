package core.http.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class ControlStatusInterceptor : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    val statusCode: Int = response.code
    if (statusCode !in 200..201) throw IllegalStateException("Unexpected http call status code :$statusCode")
    return response
  }
}