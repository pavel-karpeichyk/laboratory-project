import core.http.client.LocalHttpClient
import core.http.response.TafResponse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import steps.RegistrationPageSteps

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CallRegistrationTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"

  @Test
  fun `verify AuthUser token exists in registration response`() {
    val registrationEndpointUrl: String = RegistrationPageSteps().getPageUrl()
    val response: TafResponse = LocalHttpClient().makeGetRequest(registrationEndpointUrl)
    val expectedCookie: String? = response.getValueFromCookie(expectedUserTokenCookieName)
    assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}