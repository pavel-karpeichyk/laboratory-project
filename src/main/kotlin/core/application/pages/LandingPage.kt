package core.application.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.application.elements.Button.clickButton
import core.application.elements.Input.setInputValue
import core.holder.staticContext
import core.taf_context.static_context.StaticContextHolder
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