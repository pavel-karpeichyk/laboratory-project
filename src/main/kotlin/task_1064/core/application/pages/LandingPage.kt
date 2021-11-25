package task_1064.core.application.pages

import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import task_1064.core.application.app_config.config.AppConfigProvider
import task_1064.core.application.app_config.model.AppConfig
import task_1064.core.application.elements.Button.clickButton
import task_1064.core.application.elements.Input.setInputValue

class LandingPage : BasePage() {

  private val appConfig: AppConfig = AppConfigProvider().getAppConfig()
  private val url: String = "https://${appConfig.user}:${appConfig.pass}@${appConfig.host}"
  private val acceptCoockiesButton: SelenideElement = `$`(By.xpath("//button[@aria-label='Aceptar todo']"))
  private val loanPeriod: SelenideElement = `$`(By.id("loanDays"))
  private val loanAmount: SelenideElement = `$`(By.id("loanAmount"))
  private val requestLoanButton: SelenideElement = `$`(By.xpath("//a[@class='btn btn_red mainCalculator__submit']"))

  override fun openPage() {
    open(url)
  }

  fun clickAcceptCoockiesButton() {
    clickButton(acceptCoockiesButton)
  }

  fun setLoanPeriod(loanDays: String) {
    setInputValue(loanPeriod, loanDays)
  }

  fun setLoanAmount(amount: String) {
    setInputValue(loanAmount, amount)
    sleep(1000)
  }

  fun clickRequestButton() {
    clickButton(requestLoanButton)
  }
}