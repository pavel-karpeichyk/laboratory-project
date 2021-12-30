package core.http.interceptors

import okhttp3.logging.HttpLoggingInterceptor

class LoggerInterceptor {

  private val logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

  fun getLogger() = logger
}