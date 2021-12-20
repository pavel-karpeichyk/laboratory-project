import core.api.HTTPclient.TafResponse
import core.api.crm.controller.CrmController
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class CallCRMRegistrationTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"

  @Test
  fun `verify AuthUser token exists in cookie `() {
    val response: TafResponse = CrmController().authCrm()
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}