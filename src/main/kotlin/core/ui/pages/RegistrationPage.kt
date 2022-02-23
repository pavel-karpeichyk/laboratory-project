package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.staticContext
import org.openqa.selenium.By

class RegistrationPage : BasePage() {

  override val url: String =
    staticContext.run { getUrlWithBasicAuthSelectedEndpoint(registrationUiEndpoint) }
  private val nameField : By = By.cssSelector("input[id='userAccount.firstName']")

  override fun verifyPageOpened() {
    `$`(nameField).shouldBe(Condition.visible)
  }
}