package core.HTTP.HTTPclient

import core.holder.StaticContextHolder.getConfig
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LocalHTTPClient : TafHTTPClient {

  private val pass: String = getConfig().pass
  private val user: String = getConfig().user
  private val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
  private val client = OkHttpClient().newBuilder().addInterceptor(logger)
    .addInterceptor(ControlStatusInterceptor())
    .addInterceptor(BasicAuthInterceptor(user, pass))
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