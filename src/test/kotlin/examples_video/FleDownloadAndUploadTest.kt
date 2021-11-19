package examples_video

import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.io.File

class FleDownloadAndUploadTest {

  @Test
  fun `file download test`() {
//    var driver: WebDriver = getDriver(DriverType.CHROME)
//    driver.get("http://the-internet.herokuapp.com/download")
//    var link: WebElement = driver.findElement(By.cssSelector("div.example>a"))
//    var linkText: String = link.getAttribute("href")
//
//    var client: HttpClient = HttpClientBuilder.create().build()
//    var request: HttpHead = HttpHead(linkText)
//    var  response: HttpResponse? = client.execute(request)
//
//    var contentType: String = (response?.getFirstHeader("Content-type")?.value ?: null)!!
//    var contentLength: Int = Integer.parseInt(response?.getFirstHeader("Content-Length")?.value ?: null)!!
//
//    assertEquals(contentType, "application/octet-stream", "Doesn't match!")
//    assertTrue(contentLength>0)
//    driver.quit()

  }

  @Test
  fun `file upload test`(){
    var driver: WebDriver = getDriver(DriverType.CHROME)
    driver.get("http://the-internet.herokuapp.com/upload")
    var fileUpload: WebElement = driver.findElement(By.id("file-upload"))

    var file: File = File("src/main/resources/Снимок экрана (1).png")
    fileUpload.sendKeys(file.absolutePath)
    driver.findElement(By.id("file-submit")).click()


  }
}