package examples_video

import driver.Driver.Companion.stopDriver
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import pages.EmailPage
import pages.HomePage
import service.DataReader.Companion.credentialProperty
import service.DataReader.Companion.getCredential
import java.net.URL

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class YandexTest {

  @BeforeAll
  fun prepareCondition() {
    HomePage()
      .openPage()
    HomePage()
      .clickButtonEmail()
      .switchWindow()
      .typeEmailField(getCredential("login", credentialProperty))
      .typePasswordField(getCredential("password", credentialProperty))
      .clickProfileButton()
  }

  @Test
  fun `verify user name in email`() {
    var expectedUserName: String = EmailPage().getUserName()
    var actualUserName = "pavel.karpeichyk@moneyman.ru"
    assertEquals(expectedUserName, actualUserName, "Doesn't match email name !")
  }

  @Test
  fun `get count email`(){
    print(EmailPage().getCountEmail())
  }



  @AfterAll
  fun closeDriver() {
    stopDriver()
  }
}