package core.driver.factory

import com.codeborne.selenide.Configuration
import io.github.bonigarcia.wdm.WebDriverManager
import core.driver.config.DataDriverProvider
import core.driver.model.DriverConfig

class RemoteDriverFactory() : BaseDriverFactory() {

  override fun setDriverConfig(driveModel: DriverConfig) {
    Configuration.remote =
      "${DataDriverProvider().getConfig().hostRemoteDriver}:${DataDriverProvider().getConfig().portRemoteDriver}"
    super.setDriverConfig(driveModel)
    WebDriverManager.getInstance().setup()
  }
}