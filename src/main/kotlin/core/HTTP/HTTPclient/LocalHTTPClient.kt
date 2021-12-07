package core.HTTP.HTTPclient

import com.squareup.okhttp.Call
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import core.application.pages.LandingPage

class LocalHTTPClient : TafHTTPClient {

  override fun getClient(): OkHttpClient {
    return OkHttpClient()
  }

  override fun makeGetRequest(url: String) : Request{
   return  Request.Builder()
      .url(url)
      .build()
  }

  override fun createCall(request: Request): Call {
    return  getClient().newCall(request)
  }
}