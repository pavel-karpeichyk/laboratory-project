package examples_video

import custom_elements.Table
import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class TableTest {
  private  var driver: WebDriver = getDriver(DriverType.CHROME)
  private  var url: String= "http://the-internet.herokuapp.com/tables"

  @Test
  fun getContentFromCell(){
    driver.get(url)
    var webTable: WebElement= driver.findElement(By.cssSelector("#table1"))
    var table: String=Table(webTable).getCellContent(3,1)
    print(table)


  }

}