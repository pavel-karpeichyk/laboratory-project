package examples_video

import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class VideoTest {

  @Test
  fun `html 5 video test`() {
    var driver: WebDriver = getDriver(DriverType.CHROME)
    driver.manage().window().maximize()
    driver.get("https://www.w3schools.com/html/html5_video.asp")
   // Thread.sleep(10000)

    var videoPlayer: WebElement = driver.findElement(By.id("video1"))

    val js = driver as JavascriptExecutor

    var source: String = js.executeScript("return arguments[0].currentSrc;", videoPlayer) as String
    var duration: Double = js.executeScript("return arguments[0].duration;", videoPlayer) as Double

    assertEquals(source, "https://www.w3schools.com/html/mov_bbb.mp4", " Doesn't match")
    assertEquals(duration , 10.026667, " Doesn't match")

    js.executeScript("arguments[0].play()", videoPlayer)
    Thread.sleep(4000)

    js.executeScript("arguments[0].pause()", videoPlayer)
    Thread.sleep(4000)
    driver.quit()

  }
}