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

  private lateinit var wireMockUrl: String
  private val crmMockConfig: CrmMockConfig = CrmMockConfig()
  private lateinit var wireMockController: WireMockController
  private val actualCookieName: String = "Set-Cookie"

  @BeforeEach
  fun setupStub() {
    wireMockController = WireMockController()
    wireMockController.setUpStub(crmMockConfig)
    wireMockUrl = staticContext.getWireMockUrl()
  }

  @AfterEach
  fun removeStubs() {
    wireMockController.removeStub(crmMockConfig)
  }

  @Test
  fun `verify Wiremock stub for CRM authorisation service`() {
    val response: TafResponse = CrmController(baseUrl = wireMockUrl).authCrm()
    val expectedCookie = response.getCookie()
    val actualCookie: String? = crmMockConfig.header[actualCookieName]
    assertEquals(expectedCookie, actualCookie, "AuthUser token not found in registration response")
  }
}