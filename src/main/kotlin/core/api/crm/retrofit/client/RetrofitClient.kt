package core.api.crm.retrofit.client

import core.api.interceptors.BasicAuthInterceptor
import core.api.interceptors.LoggerInterceptor
import core.holder.StaticContextHolder.getConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

  private var retrofit: Retrofit? = null

  fun getRetrofitClient(baseUrl: String): Retrofit? {
    val client: OkHttpClient = with(getConfig()){OkHttpClient.Builder()
      .addInterceptor(LoggerInterceptor().getLogger())
      .addInterceptor(BasicAuthInterceptor(user, pass)).build()}

    retrofit = Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build() ?: throw IllegalArgumentException("Client retrofit not initialisation")
    return retrofit
  }
}