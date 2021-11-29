import core.driver.provider.DriverConfigProvider
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.TestInstance
import steps.LandingPageSteps

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeEach
  fun setupApplication() {
    DriverConfigProvider().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCoockiesButton()
    }
  }
}