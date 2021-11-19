package examples_video

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

class RemoteWebDriver {

  @Test
  fun`verify remote webdriver`(){
    var caps: DesiredCapabilities = DesiredCapabilities()
    caps.platform = Platform.WIN10
    caps.browserName = "firefox"
    var remoteDriver: RemoteWebDriver = RemoteWebDriver(URL("http://localhost:4444/"),caps)
   // var remoteDriver1: RemoteWebDriver = RemoteWebDriver(URL("http://localhost:4444/"),caps)
    remoteDriver.get("https://yandex.by")
  //  remoteDriver1.get("https://mail.ru")
    remoteDriver.manage().window().maximize()
    var emailButton: WebElement? = remoteDriver.findElement(By.xpath("//a[@class='home-link " +
        "desk-notif-card__login-new-item desk-notif-card__login-new-item_mail home-link_black_yes']"))
     emailButton?.click()


//    val firefoxOptions = FirefoxOptions()
//    val driver: WebDriver = RemoteWebDriver(URL("http://localhost:4444/"), firefoxOptions)
//    driver.get("http://www.google.com")
//    driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("hello")
//    Thread.sleep(3000)
//

  }
}