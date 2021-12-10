package core.HTTP.HTTPclient

import okhttp3.Headers
import okhttp3.Response
import okhttp3.internal.toHeaderList

class TafResponse(response: Response) {

  private var response: Response = response
  private var cookieName: String = "Set-Cookie"
  private var cookieDelimiter: String = ";"
  private var keyValueDelimiter: String = "="

  private fun getHeader(response: Response): Headers {
    return response.headers
  }

  fun getValueFromCookie(name: String): String? {
    println("HEADERS-> ${getHeader(response).toHeaderList()}")
    val cookie: String? = getHeader(response)[cookieName]
    cookie.apply {
      val cookieList: List<String> = cookie!!.split(cookieDelimiter)
      val cookieMap: Map<String, String> =
        cookieList.map { it.split(keyValueDelimiter) }.associate { it.first() to it.last() }
      return cookieMap[name]
    }
  }
}