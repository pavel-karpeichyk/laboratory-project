import com.github.tomakehurst.wiremock.WireMockServer
import core.mock.client.WireMockClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class WireMockBaseTest : BaseTest() {

  private val wireMockServer: WireMockServer = WireMockServer()
  private val wireMockClient: WireMockClient = WireMockClient()

  @BeforeAll
  fun setupWireMockServer() {
    wireMockServer.start()
    wireMockClient.getClient()
  }

  @AfterAll
  fun stopWireMockServer() {
    wireMockServer.stop()
  }
}