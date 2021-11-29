import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import core.application.pages.LandingPage
import core.driver.provider.DriverConfigProvider

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
 abstract class BaseTest {

  @BeforeAll
  fun setupApplication() {
    DriverConfigProvider().getDriverFactory()
    LandingPage().openPage().clickAcceptCoockiesButton()
  }


}