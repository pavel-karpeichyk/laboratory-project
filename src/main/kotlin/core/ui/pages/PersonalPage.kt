package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.ui.elements.Input.getInputValue
import core.ui.elements.Select.getSelectValue
import org.openqa.selenium.By

class PersonalPage : BasePage() {

  override val url: String = "$baseUrl/client-area/#/settings/personal"
  private val name: By = By.id("firstName")
  private val surname: By = By.id("firstLastName")
  private val birthDay: By = By.cssSelector("[name='birthdayDay']")
  private val birthMonth: By = By.cssSelector("[name='birthdayMonth']")
  private val birthYear: By = By.cssSelector("[name='birthdayYear']")
  private val passportNumber: By = By.id("passportIdentificationNumber")
  private val email: By = By.id("email")

  override fun verifyPageOpened() {
    `$`(name).shouldNotBe(Condition.empty)
  }

  fun getName(): String? {
    return getInputValue(name)
  }

  fun getSurname(): String? {
    return getInputValue(surname)
  }

  fun getBirthDay(): String {
    return getSelectValue(birthDay)
  }

  fun getBirthMonth(): String {
    return getSelectValue(birthMonth)
  }

  fun getBirthYear(): String {
    return getSelectValue(birthYear)
  }

  fun getPassportNumber(): String {
    return getInputValue(passportNumber)
  }

  fun getEmail(): String {
    return getInputValue(email)
  }
}