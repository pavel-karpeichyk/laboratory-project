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
  private val birthDay: By = By.id("//*[@id='birthday']/div[1]/div/select")
  private val passportNumber: By = By.id("passportIdentificationNumber")
  private val email: By = By.id("email")

  override fun verifyPageOpened() {
    `$`(name).shouldBe(Condition.value("Ta")) //
  }

  fun getName(): String? {
    return getInputValue(name)
  }

  fun getSurname(): String? {
    return getInputValue(surname)
  }

  fun getBirthDate(): String? {
    return getSelectValue(birthDay)
  }

  fun getPassportNumber(): String? {
    return getInputValue(passportNumber)
  }

  fun getEmail(): String? {
    return getInputValue(email)
  }
}