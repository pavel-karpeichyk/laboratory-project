package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import service.DataReader
import service.DataReader.Companion.getValue
import service.DataReader.Companion.locatorsProperty

class HomePage() : BasePage() {

  override fun openPage() {
    driver.get("https://yandex.by/")
  }

  //@FindBy(xpath = "//a[@class='home-link desk-notif-card__login-new-item desk-notif-card__login-new-item_mail " +
  // "home-link_black_yes']")
  private var emailButton = getValue("HomePage.emailButton", locatorsProperty)

  fun clickButtonEmail(): HomePage {
    driver.findElement(emailButton).click()
    return HomePage()
  }

  fun switchWindow(): AutherizationPage {
    for (handle in driver.windowHandles) {
      driver.switchTo().window(handle)
    }
    return AutherizationPage()
  }
}
