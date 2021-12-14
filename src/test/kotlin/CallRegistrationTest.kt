import core.HTTP.HTTPclient.LocalHTTPClient
import core.HTTP.HTTPclient.TafResponse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import steps.RegistrationPageSteps

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CallRegistrationTest : BaseTest() {

  private var name: String = "AuthUser"

  @Test
  fun `verify user token in response from registration endpoint`() {
    val registrationEndpointUrl: String = RegistrationPageSteps().getPageUrl()
    val response: TafResponse = LocalHTTPClient().makeGetRequest(registrationEndpointUrl)
    val expectedCookie: String? = response.getValueFromCookie(name)
    assertNotNull(expectedCookie, "Cookie equals null")
  }
}