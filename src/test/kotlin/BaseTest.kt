import core.application.pages.LandingPage
import core.driver.provider.DriverConfigProvider
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeEach
  fun setupApplication() {
    DriverConfigProvider().setDriverConfig()
    LandingPage().apply {
      openPage()
      clickAcceptCoockiesButton()
    }
  }
}