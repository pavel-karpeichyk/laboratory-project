package core.HTTP.HTTPclient

import com.squareup.okhttp.Call
import com.squareup.okhttp.Headers
import com.squareup.okhttp.Response
import sun.plugin.util.PluginSysUtil.execute

class TafResponse() {

fun createResponse(call: Call): Response {
  return call.execute()
}
 fun getHeader(response: Response): Headers {
 return response.headers()
}
  fun getCookie(header: Headers, name : String) : String? {
  return header.get(name)
  }
}