import core.HTTP.HTTPclient.LocalHTTPClient
import core.HTTP.HTTPclient.TafResponse
import core.application.app_config.config.AppConfigProvider
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiTest {

  private var url: String = AppConfigProvider().getUrlWithRegistrationEndPoint()
  private var name: String = "AuthUser"

  @Test
  fun `verify user token in response from registration endpoint`() {

    val response: TafResponse = LocalHTTPClient().makeGetRequest(url)
    val expectedCookie: String? = response.getValueFromCookie(name)
    assertNotNull(expectedCookie, "Cookie equals null")
  }
}