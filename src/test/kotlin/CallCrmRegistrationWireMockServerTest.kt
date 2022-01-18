import core.api.crm.controller.CrmController
import core.context.staticContext
import core.http.response.TafResponse
import core.mock.config.CrmMockConfig
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockServerTest : WireMockBaseTest() {

  private val crmMockConfig: CrmMockConfig = CrmMockConfig()
  protected lateinit var wireMockUrl: String
  private val actualCookieName: String = "Set-Cookie"

  @BeforeAll
  fun getMockUrl() {
    wireMockUrl = staticContext.getWireMockUrl()
  }

  @BeforeEach
  fun setUpCustomStub() {
    wireMockController.setUpStub(crmMockConfig)
  }

  @AfterEach
  fun removeStubs() {
    wireMockController.removeStub(crmMockConfig)
  }

  @Test
  fun `verify Wiremock stub for CRM authorisation service`() {
    val response: TafResponse = CrmController(baseUrl = wireMockUrl).authCrm()
    val expectedCookie: String? = response.getCookie()
    val actualCookie: String? = crmMockConfig.header.get(actualCookieName)
    assertEquals(expectedCookie, actualCookie, "AuthUser token not found in registration response")
  }
}