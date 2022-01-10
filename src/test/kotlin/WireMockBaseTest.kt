import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import core.mock.WireMockBuilder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class WireMockBaseTest : BaseTest() {

  private val wireMockServer: WireMockServer = WireMockServer()
  private val wireMockBuilder: WireMockBuilder = WireMockBuilder()

  @BeforeAll
  fun setupWireMockServer() {
    wireMockServer.start()
    wireMockBuilder.getClient()
  }

  @AfterAll
  fun stopWireMockServer() {
    wireMockServer.stop()
  }
}