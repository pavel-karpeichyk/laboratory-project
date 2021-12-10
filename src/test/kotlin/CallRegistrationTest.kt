import core.HTTP.HTTPclient.LocalHTTPClient
import core.HTTP.HTTPclient.TafResponse
import core.application.app_config.config.AppConfigProvider
import core.application.app_config.model.AppConfig
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CallRegistrationTest {
  private var appConfig: AppConfig = AppConfigProvider().getAppConfig()
  private var endpoint: String = "${appConfig.host}${appConfig.registrationEndPoint}"
  private var registrationEndpointUrl: String = AppConfigProvider().getUrlWithBasicAuthentification(endpoint)
  private var name: String = "AuthUser"

  @Test
  fun `verify user token in response from registration endpoint`() {
    val response: TafResponse = LocalHTTPClient().makeGetRequest(registrationEndpointUrl)
    val expectedCookie: String? = response.getValueFromCookie(name)
    assertNotNull(expectedCookie, "Cookie equals null")
  }
}