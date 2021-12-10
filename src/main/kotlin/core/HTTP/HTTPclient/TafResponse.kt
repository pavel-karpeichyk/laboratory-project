package core.HTTP.HTTPclient

import okhttp3.Headers
import okhttp3.Response

class TafResponse(response: Response) {

  private val response: Response = response
  private val cookieName: String = "Set-Cookie"
  private val cookieDelimiter: String = ";"
  private val keyValueDelimiter: String = "="

  private fun getHeaders(response: Response): Headers {
    return response.headers
  }

  fun getValueFromCookie(name: String): String? {
    val cookie: String? = getHeaders(response)[cookieName]
    cookie?.apply {
      val cookieList: List<String> = cookie.split(cookieDelimiter)
      val cookieMap: Map<String, String> =
        cookieList.map { it.split(keyValueDelimiter) }.associate { it.first() to it.last() }
      return cookieMap[name]
    }
    return cookie
  }
}