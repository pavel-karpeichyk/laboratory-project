package examples_video

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class ComplexActionTest {

  private val driver: WebDriver = getDriver(DriverType.CHROME)
  private val url: String = "http://mzabriskie.github.io/react-draggable/example/"
  private val urlAppDrawing: String = "http://www.youidraw.com/apps/painter/#"
  private val builder: Actions = Actions(driver)

  @Test
  fun `dragg and drop test`() {
    driver.get(url)
    driver.manage().window().maximize()
    val wait: WebDriverWait = WebDriverWait(driver, 10)
    val draggableBox: WebElement = driver.findElement(By.xpath("//div[text()='I can be dragged anywhere']"))
    val destinationBox: WebElement = driver.findElement(By.xpath("//div[text()='I can only be dragged horizonally']"))
    wait.until(ExpectedConditions.visibilityOf(draggableBox))

    builder.dragAndDrop(draggableBox, destinationBox).perform()
    builder.dragAndDropBy(draggableBox, 100, 100).perform()
  }

  @Test
  fun `drawing test`() {
    driver.get(urlAppDrawing)
    driver.manage().window().maximize()
    val canvas: WebElement = driver.findElement(By.id("catch"))
    driver.findElement(By.id("brush")).click()
    builder.moveToElement(canvas)
      .clickAndHold()
      .moveByOffset(200, 0)
      .moveByOffset(0, 200)
      .moveByOffset(-200, 0)
      .moveByOffset(0, -200)
      .release()
      .perform()
    driver.quit()
  }
}