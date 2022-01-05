import core.api.crm.controller.CrmController
import core.http.response.TafResponse
import core.mock.WireMockBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockStandaloneTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"
  private var wireMockBuilder: WireMockBuilder = WireMockBuilder()

  @Test
  fun ` set up wiremock standalone server and verify AuthUser token exists in cookie `() {
    with(wireMockBuilder) {
      getClient().register(getMappingStub())
    }
    val response: TafResponse = CrmController().authCrm()
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    Assertions.assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}