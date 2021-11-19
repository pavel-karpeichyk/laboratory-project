package examples_video

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class GoodYandexTest {
  private var driver: WebDriver = getDriver(DriverType.CHROME)
  private val url: String = "https://www.yandex.ru/"

  @Test
  fun `verify search content`(){
    driver.get(url)
    driver.manage().window().maximize()
    var searchField: WebElement = driver.findElement(By.cssSelector("#text"))
    searchField.sendKeys("cucumber")
    searchField.submit()

    val  resultOfSearch: List<WebElement> = driver.findElements(By.
    cssSelector("#search-result span b b"))
    println(resultOfSearch.size)

    for (result in resultOfSearch){

      println(result.text.lowercase())

      if(!result.text.lowercase().contains("cucumber")){
       fail("Not all elements")
      }
    }
  }
}