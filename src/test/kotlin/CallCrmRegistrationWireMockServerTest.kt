import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.configureFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import core.api.crm.controller.CrmController
import core.http.response.TafResponse
import core.mock.WireMockBuilder
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CallCrmRegistrationWireMockServerTest : BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"
  private var wireMockBuilder: WireMockBuilder = WireMockBuilder()
  private val wireMockServer: WireMockServer = WireMockServer()
  private val stubHost: String = "localhost"
  private val stubPort: Int = 8080

  @BeforeEach
  fun setUpServer() {
    wireMockServer.start()
  }

  @Test
  fun ` set up wiremock server and verify AuthUser token exists in cookie `() {
    configureFor(stubHost, stubPort)
    stubFor((wireMockBuilder.requestStub())?.willReturn(wireMockBuilder.responseStub()))
    val response: TafResponse = CrmController().authCrm()
    val expectedCookie = response.getValueFromCookie(expectedUserTokenCookieName)
    Assertions.assertNotNull(expectedCookie, "AuthUser token not found in registration response")
  }

  @AfterEach
  fun stopServer() {
    wireMockServer.stop()
  }
}