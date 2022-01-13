import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import core.context.staticContext
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class WireMockBaseTest : BaseTest() {

  private val wireMockServer: WireMockServer = WireMockServer()

  @BeforeAll
  fun setupWireMockServer() {
    wireMockServer.start()
  }

  @AfterAll
  fun stopWireMockServer() {
   wireMockServer.stop()
  }
}