import core.application.app_config.config.AppConfigProvider
import core.application.app_config.model.AppConfig
import core.application.elements.Browser.verifyCurrentUrl
import core.application.pages.RegistrationPage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import steps.LandingPageSteps

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest : BaseTest() {

  private val appConfig: AppConfig = AppConfigProvider().getAppConfig()
  private val expectedUrl: String = RegistrationPage().getPageUrl()
  private val loanDays: String = "7"
  private val amount: String = "100"

  @Test
  fun `verify url registration page`() {
    LandingPageSteps().apply {
      fillCalculatorForm(amount, loanDays)
      clickRequestButton()
    }
    verifyCurrentUrl("https://${appConfig.user}:${appConfig.pass}@${expectedUrl}")
  }
}