package core.application.pages

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import core.application.app_config.config.AppConfigProvider
import core.application.app_config.model.AppConfig
import core.application.elements.Button.clickButton
import core.application.elements.Input.setInputValue

class LandingPage : BasePage() {

  private val appConfig: AppConfig = AppConfigProvider().getAppConfig()
  override val url: String = "https://${appConfig.user}:${appConfig.pass}@${appConfig.host}"
  private val acceptCoockiesButton: SelenideElement = `$`(By.xpath("//button[@aria-label='Aceptar todo']"))
  private val loanPeriod: SelenideElement = `$`(By.id("loanDays"))
  private val loanAmount: SelenideElement = `$`(By.id("loanAmount"))
  private val requestLoanButton: SelenideElement = `$`(By.xpath("//a[@class='btn btn_red mainCalculator__submit']"))

   override fun openPage(): LandingPage  {
    open(url)
    return this
  }

  fun clickAcceptCoockiesButton() {
    clickButton(acceptCoockiesButton)
  }

  fun setLoanPeriod(loanDays: String) {
    setInputValue(loanPeriod, loanDays)
    Thread.sleep(1000)
  }

  fun setLoanAmount(amount: String) {
    setInputValue(loanAmount, amount)
    sleep(1000)
  }

  fun clickRequestButton() {
    clickButton(requestLoanButton)
  }
}