package examples_video

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class JUnitDataDrivenTest2 {
  private  val driver: WebDriver = getDriver(DriverType.CHROME)
  private val urlGoogle: String = "https://www.google.by"

  @ParameterizedTest(name = "Verify google request")
  @ValueSource(strings = ["Selenium", "Hello World", "Kotlin"])
   fun`google search test`(requestType: String){
    driver.get(urlGoogle)
    driver.manage().window().maximize()

    var searchField: WebElement=driver.findElement(By.name("q"))
    searchField.sendKeys(requestType)
  }
}