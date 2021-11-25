package task_1064

import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import task_1064.core.application.app_config.config.AppConfigProvider
import task_1064.core.application.app_config.model.AppConfig
import task_1064.core.application.pages.LandingPage
import task_1064.core.application.pages.RegistrationPage
import task_1064.steps.LandingPageSteps

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest : BaseTest() {

  private val appConfig: AppConfig = AppConfigProvider().getAppConfig()
  private val expectedUrl: String = RegistrationPage().getUrl()
  private val loanDays: String = "7"
  private val amount: String = "100"

  @Test
  fun `verify url registration page`() {
    LandingPageSteps().fillCalculatorForm(amount,loanDays)
    LandingPage().clickRequestButton()
    webdriver().shouldHave(url("https://${appConfig.user}:${appConfig.pass}@${expectedUrl}"))
  }
}