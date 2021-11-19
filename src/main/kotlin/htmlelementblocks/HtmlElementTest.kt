package htmlelementblocks

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.Test
import org.openqa.selenium.WebDriver

class HtmlElementTest {
  val driver: WebDriver = getDriver(DriverType.CHROME)
  @Test
  fun htmlElementTest(){
    driver.get("https://mail.yandex.by/")

  }
}