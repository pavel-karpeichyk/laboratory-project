import core.api.crm.controller.CrmController
import core.context.staticContext
import core.http.response.TafResponse
import core.mock.StubMappingService
import core.mock.config.CrmMockConfig
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockStandaloneTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"

  @BeforeEach
  fun setupStub() {
    StubMappingService().getStub(CrmMockConfig)
  }

  @AfterEach
  fun skipStubs() {
    StubMappingService().removeStubs()
  }

  @Test
  fun `setup wiremock standalone server and verify AuthUser token exists in cookie`() {
    val response: TafResponse = CrmController().authCrm(staticContext.getLocalhostUrl())
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    Assertions.assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}