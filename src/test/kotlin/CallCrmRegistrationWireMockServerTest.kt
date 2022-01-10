import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import core.api.crm.controller.CrmController
import core.context.staticContext
import core.http.response.TafResponse
import core.mock.WireMockBuilder
import core.mock.config.CrmMockConfig
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockServerTest : WireMockBaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"
  private var wireMockBuilder: WireMockBuilder = WireMockBuilder()
  private  val cmrMockConfig: CrmMockConfig = CrmMockConfig
  private  lateinit var wireMockUrl : String

@BeforeAll
fun getMockUrl(){
   wireMockUrl = staticContext.getWireMockUrl()
}

  @Test
  fun `setup wiremock server and verify AuthUser token exists in cookie`() {
    stubFor((wireMockBuilder.getMappingStub(cmrMockConfig))?.willReturn(wireMockBuilder.responseStub(cmrMockConfig)))
    val response: TafResponse = CrmController().authCrm(wireMockUrl)
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    Assertions.assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }
}