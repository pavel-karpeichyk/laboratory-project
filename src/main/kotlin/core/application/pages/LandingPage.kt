package core.application.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.application.app_config.config.AppConfigProvider
import core.application.app_config.model.AppConfig
import core.application.elements.Button.clickButton
import core.application.elements.Input.setInputValue
import org.openqa.selenium.By

class LandingPage : BasePage() {

  private var appConfig: AppConfig = AppConfigProvider().getAppConfig()
  override val url: String = AppConfigProvider().getUrlWithBasicAuthentification(appConfig.host)
  private val acceptCoockiesButton: By = By.xpath("//button[@aria-label='Aceptar todo']")
  private val loanPeriodInput: By = By.id("loanDays")
  private val loanAmountInput: By = By.id("loanAmount")
  private val requestLoanButton: By = By.xpath("//a[@class='btn btn_red mainCalculator__submit']")

  fun clickAcceptCoockiesButton() {
    clickButton(acceptCoockiesButton)
  }

  fun setLoanPeriod(loanDays: String) {
    setInputValue(loanPeriodInput, loanDays)
  }

  fun setLoanAmount(amount: String) {
    setInputValue(loanAmountInput, amount)
  }

  fun clickRequestButton() {
    clickButton(requestLoanButton)
  }

  fun verifyRequestLoanButtonIsDisplayed() {
    `$`(requestLoanButton).shouldBe(Condition.visible)
  }
}