package task_1064

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import task_1064.core.application.pages.LandingPage
import task_1064.driver.config.DataDriverProvider
import task_1064.driver.provider.DriverConfigProvider

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open abstract class BaseTest {

    @BeforeAll
    fun setupApplication() {
     DriverConfigProvider().getDriverFactory(DataDriverProvider())
      LandingPage().openPage()
      LandingPage().clickAcceptCoockiesButton()
    }
  }