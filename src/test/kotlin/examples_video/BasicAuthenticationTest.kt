package examples_video

import driver.Driver.Companion.getDriver
import driver.DriverType
import net.lightbody.bmp.proxy.ProxyServer
import org.junit.jupiter.api.Test
import org.openqa.selenium.Proxy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.util.concurrent.TimeUnit

class BasicAuthenticationTest {

  private var userName: String = "admin"
  private var password: String = "admin"

  @Test
  fun basicAuthUrlTest() {
    var driver: WebDriver = getDriver(DriverType.CHROME)
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.get("http://${userName}:${password}@the-internet.herokuapp.com/basic_auth")
    driver.close()
  }

  @Test
  fun `browser map proxy test`() {
    var proxyServer: ProxyServer = ProxyServer(5556)
    proxyServer.start()
    proxyServer.autoBasicAuthorization("", userName, password)

    var proxy: Proxy = proxyServer.seleniumProxy()
    var caps: DesiredCapabilities = DesiredCapabilities()
    caps.setCapability(CapabilityType.PROXY, proxy)

    var chromeDriver = ChromeDriver(caps)
    chromeDriver.manage().window().maximize()
    chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    var driver: WebDriver = getDriver(DriverType.CHROME)
    proxyServer.stop()
  }
}