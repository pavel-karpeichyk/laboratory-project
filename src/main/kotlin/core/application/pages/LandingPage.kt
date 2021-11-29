package core.application.pages

import com.codeborne.selenide.Selenide.sleep
import core.application.app_config.config.AppConfigProvider
import core.application.app_config.model.AppConfig
import core.application.elements.Button.clickButton
import core.application.elements.Input.setInputValue
import org.openqa.selenium.By

class LandingPage : BasePage() {

  private val appConfig: AppConfig = AppConfigProvider().getAppConfig()
  override val url: String = "https://${appConfig.user}:${appConfig.pass}@${appConfig.host}"
  private val acceptCoockiesButton: By = By.xpath("//button[@aria-label='Aceptar todo']")
  private val loanPeriod: By = By.id("loanDays")
  private val loanAmount: By = By.id("loanAmount")
  private val requestLoanButton: By = By.xpath("//a[@class='btn btn_red mainCalculator__submit']")

  fun clickAcceptCoockiesButton() {
    clickButton(acceptCoockiesButton)
  }

  fun setLoanPeriod(loanDays: String) {
    setInputValue(loanPeriod, loanDays)
    sleep(1000)
  }

  fun setLoanAmount(amount: String) {
    setInputValue(loanAmount, amount)
    sleep(1000)
  }

  fun clickRequestButton() {
    clickButton(requestLoanButton)
  }
}