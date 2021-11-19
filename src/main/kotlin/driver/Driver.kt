package driver

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class Driver {

  companion object {

    private var driver: WebDriver? = null

    fun getDriver(driverType: DriverType): WebDriver {
      if (driver == null) {
        when (driverType) {
          DriverType.FIREFOX -> driver = FirefoxDriver()
          DriverType.CHROME -> driver = ChromeDriver()
          else -> driver = ChromeDriver()
        }
      }
      driver!!.manage().window().maximize()
      return driver!!
    }

    fun stopDriver() {
      driver!!.close()
    }
  }
}



