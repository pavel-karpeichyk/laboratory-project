package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.staticContext
import core.ui.elements.Button.clickButton
import core.ui.elements.Input.setInputValueToPrefilledFiledAndVerify
import org.openqa.selenium.By

class LandingPage : BasePage() {

  override val url: String = staticContext.getBaseUrlWithAuth()
  private val acceptCookiesButton: By = By.xpath("//button[@aria-label='Aceptar todo']")
  private val loanPeriodInput: By = By.id("loanDays")
  private val loanAmountInput: By = By.id("loanAmount")
  private val requestLoanButton: By = By.xpath("//a[@class='btn btn_red mainCalculator__submit']")

  override fun verifyPageOpened() {
    `$`(loanPeriodInput).shouldBe(Condition.visible)
  }

  fun clickAcceptCookiesButton() {
    clickButton(acceptCookiesButton)
  }

  fun setLoanPeriod(loanDays: String) {
    setInputValueToPrefilledFiledAndVerify(loanPeriodInput, loanDays)
  }

  fun setLoanAmount(amount: String) {
    setInputValueToPrefilledFiledAndVerify(loanAmountInput, amount)
  }

  fun clickRequestButton() {
    clickButton(requestLoanButton)
  }

  fun verifyRequestLoanButtonIsDisplayed() {
    `$`(requestLoanButton).shouldBe(Condition.visible)
  }
}