package examples_video

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.openqa.selenium.Alert
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.util.concurrent.TimeUnit

class ControlingTest {
  private val driver: WebDriver = getDriver(DriverType.CHROME)
  private val url: String = "https://www.yandex.ru/"
  private val urlAlerts: String = "http://the-internet.herokuapp.com/javascript_alerts"
  private val urlFrames: String = "http://the-internet.herokuapp.com/nested_frames"

  @Test
  fun `multiple windows test`() {
    driver.get(url)
    driver.manage().window().maximize()
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS)
    var startWindowHandle: String = driver.windowHandle
    driver.findElement(By.xpath("//a[@data-id='translate']")).click()

    for (handle in driver.windowHandles) {
      driver.switchTo().window(handle)
    }

    var mark: WebElement = driver.findElement(By.xpath("//nav//a[@href='/']"))

    assertEquals(mark.text, "Текст", "String doesn't match")
    driver.close()
    driver.switchTo().window(startWindowHandle)
    mark = driver.findElement(By.xpath("//a[@data-id='translate']/div[@class='services-new__item-title']"))

    assertEquals(mark.text, "Переводчик","String doesn't match")
    driver.quit()
  }

  @Test
  fun `alert test`(){
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.get(urlAlerts)
    //driver.findElement(By.ByCssSelector("[onclick='jsAlert()']")).click()
    driver.findElement(By.ByCssSelector("[onclick='jsPrompt()']")).click()
    var alert: Alert =driver.switchTo().alert()
   // assertEquals(alert.text , "I am a JS Alert", "String doesn't match")
   // assertEquals(alert.text , "Click for JS Confirm", "String doesn't match")
    alert.sendKeys("Hello PAvel")
    alert.dismiss()
  }

  @Test
  fun `frame test` (){
    driver.get(urlFrames)
    driver.manage().window().maximize()
    driver.switchTo().frame("frame-top")
    driver.switchTo().frame("frame-left")
    assertEquals(driver.findElement(By.tagName("body")).text, "LEFT")

    driver.switchTo().parentFrame()

    //driver.switchTo().frame("frame-top")
    driver.switchTo().frame("frame-right")
    assertEquals(driver.findElement(By.tagName("body")).text, "RIGHT")


  }
}