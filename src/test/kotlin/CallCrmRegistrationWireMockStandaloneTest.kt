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
  fun skipStubs() {
    wireMockController.removeStub(crmMockConfig)
  }

  @Test
  fun `verify the AuthUser token in cookie is equals that we set in wireMock response when authorization into CRM with incorrect credentials`() {
    val response: TafResponse = CrmController(baseUrl = wireMockUrl).authCrm()
    val expectedCookie = response.getCookie()
    val actualCookie: String? = crmMockConfig.header[actualCookieName]
    assertEquals(expectedCookie, actualCookie, "AuthUser token not found in registration response")
  }
}