package examples_video

import driver.Driver.Companion.getDriver
import driver.DriverType
import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import java.io.File

class CanvasTest {

  @Test
  fun ` canvas test`(){
    var initialFilePath: String =".//target/screenshots/initialFile.png"
    var actualFilePath: String =".//target/screenshots/actualFile.png"

    var driver: WebDriver = getDriver(DriverType.CHROME)
    driver.manage().window().maximize()
    driver.get("https://www.youidraw.com/apps/painter/")
    var canvas: WebElement= driver.findElement(By.id("catch"))

    driver.findElement(By.id("brush")).click()

    FileUtils.copyFile(ScreenshotTest().createScreenshot(driver, canvas), File(initialFilePath))

    var builder: Actions = Actions(driver)
    builder.clickAndHold(canvas)
      .moveByOffset(50,50)
      .moveByOffset(-50,50)
      .moveByOffset(-50,50)
      .moveByOffset(50,-50)
      .release().perform()

    FileUtils.copyFile(ScreenshotTest().createScreenshot(driver, canvas), File(actualFilePath))

    assertEquals(ScreenshotTest().compareImages(initialFilePath, actualFilePath),
      ScreenshotTest.Result.PIXEL_MISMATCH,"Don't match!")


  }
}