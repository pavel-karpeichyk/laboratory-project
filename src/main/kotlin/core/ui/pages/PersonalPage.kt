package core.ui.pages

import core.context.staticContext
import core.ui.elements.Input.getInputValue
import org.openqa.selenium.By

class PersonalPage : BasePage() {

  override val url: String = staticContext.getPersonalUrl()
  private val name: By = By.id("firstName")
  private val surname: By = By.id("firstLastName")
  private val birthDate: By = By.id("birthday")
  private val passportNumber: By = By.id("passportIdentificationNumber")
  private val email: By = By.id("email")

  fun getPageUrl(): String {
    return url
  }

  fun getName(): String? {
    return getInputValue(name)
  }

  fun getSurname(): String? {
    return getInputValue(surname)
  }

  fun getBirthDate() {
TODO()
  }

  fun getPassportNumber(): String? {
    return getInputValue(passportNumber)
  }

  fun getEmail(): String? {
    return getInputValue(email)
  }
}