import core.application.elements.Browser.verifyCurrentUrl
import core.application.pages.RegistrationPage
import core.driver.provider.DriverConfigSetter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import steps.LandingPageSteps

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest : BaseUITest() {

  private val loanDays: String = "7"
  private val amount: String = "100"

  @Test
  fun `Submit Landing Page calculator values and verify redirect on Registration Page`() {
    val expectedUrl: String = RegistrationPage().getPageUrl()
    DriverConfigSetter().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCoockiesButton()
      fillCalculatorForm(amount, loanDays)
      clickRequestButton()
    }
    verifyCurrentUrl(expectedUrl)
  }
}