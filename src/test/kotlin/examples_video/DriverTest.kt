package examples_video

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver

class DriverTest {
  private var driver: WebDriver = getDriver(DriverType.CHROME)

  @Test
  fun `get driver test`(){
    driver.get("https://www.google.by/")
    driver.manage().window().maximize()

  }
}