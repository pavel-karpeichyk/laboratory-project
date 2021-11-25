package task_1064.driver.factory

import com.codeborne.selenide.Configuration
import io.github.bonigarcia.wdm.WebDriverManager
import task_1064.driver.config.DataDriverProvider

class RemoteDriverFactory() : DriverFactory {

  override fun setDriverConfig(dataDriverConfig: DataDriverProvider) {
    Configuration.remote =
      "${dataDriverConfig.getConfig().hostRemoteDriver}:${dataDriverConfig.getConfig().portRemoteDriver}"
    BaseDriverFactory().setDriverConfig(dataDriverConfig)
    WebDriverManager.getInstance().setup()
  }
}