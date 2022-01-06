import core.api.crm.controller.CrmController
import core.http.response.TafResponse
import core.mock.Service
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockStandaloneTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"

  @BeforeEach
  fun setupStub() {
    Service().getStub()
  }

  @Test
  fun `setup wiremock standalone server and verify AuthUser token exists in cookie`() {
    val response: TafResponse = CrmController().authCrm()
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    Assertions.assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }

  @AfterEach
  fun skipStubs() {
    Service().removeStubs()
  }
}