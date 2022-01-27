import core.ui.driver.setter.DriverConfigSetter
import core.ui.elements.Browser
import core.watcher.CustomWatcher
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import steps.LandingPageSteps

@ExtendWith(CustomWatcher::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FailedCalculatorTest : BaseTest() {

  private val expectedLoanDays: String = "7"
  private val expectedAmount: String = "100"
  private val expectedUrl: String = "http//someurl"

  @Test
  fun `Submit Landing Page calculator values and verify redirect on Registration Page`() {

    DriverConfigSetter().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCoockiesButton()
      fillCalculatorForm(expectedAmount, expectedLoanDays)
      clickRequestButton()
    }
    Browser.verifyCurrentUrl(expectedUrl)
  }
}