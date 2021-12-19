package core.api.crm.retrofit.client

import core.api.interceptors.BasicAuthInterceptor
import core.api.interceptors.LoggerInterceptor
import core.holder.StaticContextHolder.getConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

  private var retrofit: Retrofit? = null
  private val pass: String = getConfig().pass
  private val user: String = getConfig().user

  fun getRetrofitClient(baseUrl: String): Retrofit? {
    val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
      .addInterceptor(LoggerInterceptor().getLogger())
      .addInterceptor(BasicAuthInterceptor(user, pass))

    retrofit = Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClient.build())
      .build() ?: throw IllegalArgumentException("Client retrofit not initialisation")
    return retrofit
  }
}