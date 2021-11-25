package task_1064

import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.Platform
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import task_1064.core.application.pages.LandPage
import task_1064.core.steps.CommonSteps
import java.net.URL

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest : TestBase() {

  private val expectedUrl: String = "es-alpha.moneyman.ru/client-area/#/registration?"
  private val loanDays: String = "7"
  private val amount: String = "100"

  @Test
  fun `verify url registration page`() {
    CommonSteps().fillCalculatorForm(amount,loanDays)
    LandPage().clickRequestButton()
    webdriver().shouldHave(url("https://${appConfig.user}:${appConfig.pass}@${expectedUrl}"))
  }
}