package core.application.pages

import com.codeborne.selenide.Selenide.sleep
import core.application.elements.Button.clickButton
import core.application.elements.Input.setInputValue
import core.holder.StaticContextHolder.appConfic
import org.openqa.selenium.By

class LandingPage : BasePage() {

  override val url: String = "https://${appConfic?.user}:${appConfic?.pass}@${appConfic?.host}"
  private val acceptCoockiesButton: By = By.xpath("//button[@aria-label='Aceptar todo']")
  private val loanPeriodInput: By = By.id("loanDays")
  private val loanAmountInput: By = By.id("loanAmount")
  private val requestLoanButton: By = By.xpath("//a[@class='btn btn_red mainCalculator__submit']")

  fun clickAcceptCoockiesButton() {
    clickButton(acceptCoockiesButton)
  }

  fun setLoanPeriod(loanDays: String) {
    setInputValue(loanPeriodInput, loanDays)
    sleep(1000)
  }

  fun setLoanAmount(amount: String) {
    setInputValue(loanAmountInput, amount)
    sleep(1000)
  }

  fun clickRequestButton() {
    clickButton(requestLoanButton)
  }
}