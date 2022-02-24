package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.ui.elements.Button.clickButton
import core.ui.elements.Input.setInputValue
import core.ui.elements.Input.setInputValueAndVerify
import org.openqa.selenium.By

class PrivateAreaLoginPage : BasePage() {

  override val url: String = "$baseUrl/secure/login"
  private val acceptCookiesButton: By = By.cssSelector("button[aria-label='Aceptar todo']")
  private val passportField: By = By.id("identifier")
  private val authorizeButton: By = By.cssSelector("button[data-test-id='authorize']")
  private val smsCodeInput: By = By.id("otp")

  override fun verifyPageOpened() {
    `$`(passportField).shouldBe(Condition.visible)
  }

  fun clickAcceptCookiesButton() {
    clickButton(acceptCookiesButton)
  }

  fun setPassportNumber(number: String) {
    setInputValueAndVerify(passportField, number)
  }

  fun clickAuthorizeButton() {
    clickButton(authorizeButton)
  }

  fun setSmsCodeField(code: String) {
    setInputValue(smsCodeInput, code)
  }
}