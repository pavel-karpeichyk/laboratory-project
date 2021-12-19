import core.api.HTTPclient.TafResponse
import core.api.crm.controller.CrmController
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class RetrofitCRMTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"

  @Test
  fun `verify AuthUser token exists in cookie `() {
    val expectedCookie = TafResponse(CrmController().authCrm()).getValueFromCookie(expectedUserTokenCookieName)
    assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}