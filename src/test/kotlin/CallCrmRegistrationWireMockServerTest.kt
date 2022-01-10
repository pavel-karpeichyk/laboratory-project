import core.api.crm.controller.CrmController
import core.context.staticContext
import core.http.response.TafResponse
import core.mock.WireMockBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockServerTest : WireMockBaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"
  private var wireMockBuilder: WireMockBuilder = WireMockBuilder()

  @Test
  fun `setup wiremock server and verify AuthUser token exists in cookie`() {
    val response: TafResponse = CrmController().authCrm(staticContext.getLocalhostUrl())
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    Assertions.assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}