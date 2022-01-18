import com.github.tomakehurst.wiremock.WireMockServer
import core.mock.controller.WireMockController
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class WireMockBaseTest : BaseTest() {

  private val wireMockServer: WireMockServer = WireMockServer()
  protected lateinit var wireMockController: WireMockController

  @BeforeAll
  fun setupWireMockServer() {
    wireMockController = WireMockController()
    wireMockServer.start()
  }

  @AfterAll
  fun stopWireMockServer() {
    wireMockServer.stop()
  }
}