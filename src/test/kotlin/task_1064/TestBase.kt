package task_1064

import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import task_1064.core.application.app_config.config.AppConfig
import task_1064.core.application.app_config.model.AppConfigModel
import task_1064.core.application.pages.LandPage
import task_1064.driver.config.DataDriverConfig
import task_1064.driver.provider.DriverConfigProvider

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class TestBase {

val appConfig: AppConfigModel = AppConfig().getAppConfig()

    @BeforeAll
    fun setupApplication() {
     DriverConfigProvider().getDriverFactory(DataDriverConfig())
      open("https://${appConfig.user}:${appConfig.pass}@${appConfig.host}")
      LandPage().clickAcceptCoockiesButton()
    }
  }