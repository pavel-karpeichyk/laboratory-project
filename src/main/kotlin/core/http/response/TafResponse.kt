package core.http.response

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

  fun getCookie(): String? = getHeaders(response)[cookieName]

  fun getValueFromCookie(name: String): String? {
    var cookieValue: String? = null
    getCookie()?.also { cookie ->
      val cookieList: List<String> = cookie.split(cookieDelimiter)
      val cookieMap: Map<String, String> =
        cookieList.map { it.split(keyValueDelimiter) }.associate { it.first() to it.last() }
      cookieValue = cookieMap[name]
    }
    return cookieValue
  }
}