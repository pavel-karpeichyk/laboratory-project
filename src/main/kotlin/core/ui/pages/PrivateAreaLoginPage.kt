package core.ui.pages

import core.context.staticContext
import core.ui.elements.Button.clickButton
import core.ui.elements.Input.setInputValue
import org.openqa.selenium.By

class PrivateAreaLoginPage : BasePage() {

  override val url: String = staticContext.getPrivateAreaLoginUrl()
  private val smsCode: String = staticContext.smsCode
  private val acceptCookiesButton: By = By.cssSelector("button[aria-label='Aceptar todo']")
  private val passportField: By = By.id("identifier")
  private val authorizeButton: By = By.cssSelector("button[data-test-id='authorize']")
  private val smsCodeInput: By = By.id("otp")

  fun clickAcceptCookiesButton() {
    clickButton(acceptCookiesButton)
  }

  fun fillPassportNumber(number: String) {
    setInputValue(passportField, number)
  }

  fun clickAuthorizeButton() {
    clickButton(authorizeButton)
  }

  fun fillSmsCodeField() {
    setInputValue(smsCodeInput, smsCode)
  }
}