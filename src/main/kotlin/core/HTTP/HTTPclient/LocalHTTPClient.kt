package core.HTTP.HTTPclient

import core.application.app_config.config.AppConfigProvider
import core.application.app_config.model.AppConfig
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LocalHTTPClient : TafHTTPClient {

  private val appConfig: AppConfig = AppConfigProvider().getAppConfig()
  private val pass: String = appConfig.pass
  private val user: String = appConfig.user
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