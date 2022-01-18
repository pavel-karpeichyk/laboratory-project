package core.http.retrofit

import core.context.staticContext
import core.http.interceptors.BasicAuthInterceptor
import core.http.interceptors.LoggerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

  private val client: OkHttpClient = with(staticContext) {
    OkHttpClient.Builder()
      .addInterceptor(LoggerInterceptor().getLogger())
      .addInterceptor(BasicAuthInterceptor(user, pass))
      .build()
  }

  fun getRetrofitClient(baseUrl: String): Retrofit {
    return Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build() ?: throw IllegalArgumentException("Client retrofit not initialisation")
  }
}