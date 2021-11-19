package core

import driver.Driver
import driver.DriverType
import net.lightbody.bmp.core.har.Har
import net.lightbody.bmp.proxy.ProxyServer
import org.junit.jupiter.api.BeforeEach
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import java.io.File
import java.util.concurrent.TimeUnit

open class PerformanceTestBase {

  protected var driver: WebDriver? = null
  private var proxy: ProxyServer? = null
  private var har: Har? = null

  @BeforeMethod
  protected fun `setup`() {
    proxy = ProxyServer(4444)
    proxy!!.start()

    proxy!!.setRequestTimeout(60000)
    var caps: DesiredCapabilities = DesiredCapabilities()
    caps.setCapability(CapabilityType.PROXY, proxy!!.seleniumProxy())

    driver = ChromeDriver()
    driver!!.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver!!.manage().window().maximize()

  }
  @AfterMethod
  protected fun tearDown(){
    saveHar()
    proxy!!.stop()

  }

  protected  fun startHarRecording(){
    proxy!!.newHar("performanceTest")
  }

  protected fun finishHarRecording(){
    har= proxy!!.har

  }

  protected fun saveHar(){
    har!!.writeTo(File("C:\\test.har"))

  }
}