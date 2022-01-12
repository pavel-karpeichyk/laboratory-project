import core.api.crm.controller.CrmController
import core.context.staticContext
import core.http.response.TafResponse
import core.mock.config.CrmMockConfig
import core.mock.controller.WireMockController
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockServerTest : WireMockBaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"
  private val cmrMockConfig: CrmMockConfig = CrmMockConfig()
  protected lateinit var wireMockUrl: String

  @BeforeAll
  fun getMockUrl() {
    wireMockUrl = staticContext.getWireMockUrl()
  }

  @BeforeEach
  fun setUpCustomStub(){
    WireMockController().setUpStub(cmrMockConfig)
  }

  @Test
  fun `setup wiremock server and verify AuthUser token exists in cookie`() {
    val response: TafResponse = CrmController(baseUrl = wireMockUrl).authCrm()
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    Assertions.assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}