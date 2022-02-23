package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.staticContext
import core.ui.elements.Input.getInputValue
import org.openqa.selenium.By

class PersonalPage : BasePage() {

  private val baseUrl: String = staticContext.getBaseUrl() // занести в базовый класс
  override val url: String = "$baseUrl/client-area/#/settings/personal"
  private val name: By = By.id("firstName")
  private val surname: By = By.id("firstLastName")
  private val birthDate: By = By.id("birthday")
  private val passportNumber: By = By.id("passportIdentificationNumber")
  private val email: By = By.id("email")

  override fun verifyPageOpened() {
    `$`(name).shouldBe(Condition.visible)
  }

  fun getName(): String? {
    return getInputValue(name)
  }

  fun getSurname(): String? {
    return getInputValue(surname)
  }

  fun getBirthDate(): String? {
    TODO()
  }

  fun getPassportNumber(): String? {
    return getInputValue(passportNumber)
  }

  fun getEmail(): String? {
    return getInputValue(email)
  }
}