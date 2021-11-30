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
  private val registrationPageUrl: String = RegistrationPage().getPageUrl()
  private val expectedUrl: String = "https://${appConfig.user}:${appConfig.pass}@${registrationPageUrl}"
  private val loanDays: String = "7"
  private val amount: String = "100"

  @Test
  fun `Submit Landing Page calculator values and verify redirect on Registration Page`() {
    LandingPageSteps().apply {
      fillCalculatorForm(amount, loanDays)
      clickRequestButton()
    }
    verifyCurrentUrl(expectedUrl)
  }
}