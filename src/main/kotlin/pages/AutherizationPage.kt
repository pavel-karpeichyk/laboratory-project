package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import service.DataReader
import service.DataReader.Companion.getValue
import java.util.concurrent.TimeUnit

class AutherizationPage : BasePage() {

  private val wait: WebDriverWait = WebDriverWait(driver, 30)

  override fun openPage() {
  }

  // @FindBy(css = "#passp-field-login")
  private var emailField: By = getValue("AutherizationPage.emailField", DataReader.locatorsProperty)

  //@FindBy(xpath = "//button[@id='passp:sign-in']")
  private var singInButton: By = getValue("AutherizationPage.singInButton", DataReader.locatorsProperty)

  // @FindBy(css = "#passp-field-passwd")
  private var passwordField: By = getValue("AutherizationPage.passwordField", DataReader.locatorsProperty)

  fun typeEmailField(email: String): AutherizationPage {
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
    driver.findElement(emailField).clear()
    driver.findElement(emailField).sendKeys(email)
    driver.findElement(singInButton).submit()
    return AutherizationPage()
  }

  fun typePasswordField(password: String): EmailPage {
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
    var passwordArea: WebElement = driver.findElement(passwordField)
    passwordArea.clear()
    passwordArea.sendKeys(password)
    driver.findElement(singInButton).submit()
    return EmailPage()

  }

}