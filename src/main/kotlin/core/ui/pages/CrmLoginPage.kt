package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.ui.elements.Button.clickButton
import core.ui.elements.Input.setInputValueAndVerify
import org.openqa.selenium.By

class CrmLoginPage : BasePage() {

  override val url: String = "$baseUrl/secure/new-admin/index.html#/login"
  private val loginInput: By = By.id("username")
  private val passwordInput: By = By.id("password")
  private val captchaInput: By = By.id("captcha")
  private val loginButton: By = By.cssSelector("#main button[type='submit']")

  override fun verifyPageOpened() {
    `$`(loginInput).shouldBe(Condition.visible)
  }

  fun setLogin(login: String) {
    setInputValueAndVerify(loginInput, login)
  }

  fun setPassword(password: String) {
    setInputValueAndVerify(passwordInput, password)
  }

  fun setCaptcha(captcha: String) {
    setInputValueAndVerify(captchaInput, captcha)
  }

  fun submitLoginButton() {
    clickButton(loginButton)
  }
}