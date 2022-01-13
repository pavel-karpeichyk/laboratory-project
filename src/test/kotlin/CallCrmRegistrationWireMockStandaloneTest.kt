import core.api.crm.controller.CrmController
import core.context.staticContext
import core.http.response.TafResponse
import core.mock.config.CrmMockConfig
import core.mock.controller.WireMockController
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockStandaloneTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"
  private lateinit var wireMockUrl: String
  private val crmMockConfig: CrmMockConfig = CrmMockConfig()

  @BeforeEach
  fun setupStub() {
    WireMockController().setUpStub(crmMockConfig)
    wireMockUrl = staticContext.getWireMockUrl()
  }

  @AfterEach
  fun skipStubs() {
    WireMockController().removeStub(crmMockConfig)
  }

  @Test
  fun `setup wiremock standalone server and verify AuthUser token exists in cookie`() {
    val response: TafResponse = CrmController(baseUrl = wireMockUrl).authCrm()
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    assertEquals(expectedCookie, "fakeAuthToken", "AuthUser token not found in registration response")
  }
}