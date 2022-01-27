package core.http.client

import core.context.staticContext
import core.http.interceptors.BasicAuthInterceptor
import core.http.interceptors.ControlStatusInterceptor
import core.http.response.TafResponse
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LocalHttpClient : TafHttpClient {

  private val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
  private val client = with(staticContext) {
    OkHttpClient().newBuilder()
      .addInterceptor(logger)
      .addInterceptor(ControlStatusInterceptor())
      .addInterceptor(BasicAuthInterceptor(user, pass))
  }
    .build()

  override fun getClient(): OkHttpClient {
    return client
  }

  override fun makeGetRequest(url: String): TafResponse {
    val request: Request = Request.Builder().get().url(url).build()
    val call: Call = client.newCall(request)
    val response: Response = call.execute()
    return TafResponse(response)
  }
}