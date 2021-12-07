package core.HTTP.HTTPclient

import com.squareup.okhttp.Call
import com.squareup.okhttp.Request

interface TafHTTPClient {

  fun getClient(): Any
  fun makeGetRequest( url: String): Request
  fun createCall (request : Request): Call
}