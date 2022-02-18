package core.ui.pages

import core.context.staticContext
import core.ui.elements.Button.clickButton
import core.ui.elements.Input
import core.ui.elements.Input.setInputValue
import core.ui.elements.Input.setInputValueWithCondition
import org.openqa.selenium.By

class CrmLoginPage : BasePage() {

  override val url: String = staticContext.getCrmLoginUrl()

  private val loginInput: By = By.id("username")
  private val passwordInput: By = By.id("password")
  private val captchaInput: By = By.id("captcha")
  private val loginButton: By = By.xpath("//*[@id='main']//button[@type='submit']")

  fun setLogin(login: String) {
    setInputValue(loginInput, login)
  }

  fun setPassword(password: String) {
    setInputValue(passwordInput, password)
  }

  fun setCaptcha(captcha: String) {
    setInputValue(captchaInput, captcha)
  }

  fun submitLoginButton() {
    clickButton(loginButton)
  }
}