package examples_video

import driver.Driver
import driver.DriverType
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.util.logging.Level

class LoggingTest {
  var driver: WebDriver?=null

  @Test
  fun`logging test`(){
    var logs: LoggingPreferences= LoggingPreferences()
    logs.enable(LogType.DRIVER, Level.ALL)
    var caps: DesiredCapabilities = DesiredCapabilities()
    caps.setCapability(CapabilityType.LOGGING_PREFS, logs)

     driver = ChromeDriver(caps)
    driver?.manage()?.window()?.maximize()
    driver?.get("http://the-internet.herokuapp.com")

    `print logs`()
    driver?.quit() //don't work(
  }

  private fun`print logs`(){
    var logEntries: LogEntries? = driver?.manage()?.logs()?.get(LogType.DRIVER)

    for (logEntry in logEntries!!){
      println(logEntry.message)
    }
  }
}