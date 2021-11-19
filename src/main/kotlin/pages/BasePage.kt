package pages

import driver.Driver.Companion.getDriver
import driver.DriverType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

abstract class BasePage() {

  abstract fun openPage()
  protected val driver: WebDriver = getDriver(DriverType.CHROME)

  init {
    PageFactory.initElements(driver, this)
  }
}