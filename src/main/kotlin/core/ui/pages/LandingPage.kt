package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.staticContext
import core.ui.elements.Button.clickButton
import core.ui.elements.Input.setInputValue
import org.openqa.selenium.By

class LandingPage : BasePage() {

  override val url: String = staticContext.getBaseUrlWithAuth()
  private val acceptCookiesButton: By = By.xpath("//button[@aria-label='Aceptar todo']")
  private val loanPeriodInput: By = By.id("loanDays")
  private val loanAmountInput: By = By.id("loanAmount")
  private val requestLoanButton: By = By.xpath("//a[@class='btn btn_red mainCalculator__submit']")

  fun clickAcceptCoockiesButton() {
    clickButton(acceptCookiesButton)
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