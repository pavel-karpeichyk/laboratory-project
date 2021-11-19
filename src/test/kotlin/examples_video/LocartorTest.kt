package examples_video

import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class LocartorTest {
  private  var driver: WebDriver = getDriver(DriverType.CHROME)
  private var url: String = "https://www.yandex.ru/"

@Test
fun `verify different way locators`(){
  driver.get(url)
  driver.manage().window().maximize()
  var wait: WebDriverWait= WebDriverWait(driver, 10)

  var fieldSearch: WebElement= driver.findElement(By.id("text"))
  wait.until(ExpectedConditions.visibilityOf(fieldSearch))

  fieldSearch.sendKeys("Hello Pavel")
  fieldSearch.submit()

  var resultSearch: List <WebElement> = driver.findElements(By.xpath("//li[contains(@class,'navigation__item navigation__item')]"))



}

}