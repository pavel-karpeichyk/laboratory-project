import com.squareup.okhttp.CertificatePinner
import com.squareup.okhttp.HttpUrl
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import com.squareup.okhttp.logging.HttpLoggingInterceptor
import core.HTTP.HTTPclient.LocalHTTPClient
import core.HTTP.HTTPclient.TafResponse
import core.HTTP.StringParser
import core.application.app_config.config.AppConfigProvider
import core.holder.StaticContextHolder.clearContext
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiTest {

  private val appConfic = AppConfigProvider().getAppConfig()
  private val endPoint: String = "/client-area/registration"
  private var url: String = "https://${appConfic.user}:${appConfic.pass}@${appConfic.host}$endPoint"
  private val localHTTPClient: LocalHTTPClient by lazy { LocalHTTPClient() }
  private val tafResponse: TafResponse by lazy { TafResponse() }
  var logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)

  @Test
  fun `verify user token in response from registration endpoint`() {

    var call = localHTTPClient.createCall(localHTTPClient.makeGetRequest(url))
    val response: Response = tafResponse.createResponse(call)
    if (response.isSuccessful) {
      val cookie = tafResponse.getCookie(tafResponse.getHeader(response), "Set-Cookie")
      assertNotEquals(response, null, "Response is empty")
      assertNotEquals(cookie?.let { StringParser().getValueFromCookie(it) }, "", "Token AuthUser in cookie is empty")
    } else {
      throw Exception("The call isn't successful")
    }
  }

  @AfterAll
  fun cleanup() {
    clearContext()
  }
}