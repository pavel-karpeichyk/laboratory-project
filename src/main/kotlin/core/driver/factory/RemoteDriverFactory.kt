package core.driver.factory

import com.codeborne.selenide.Configuration
import io.github.bonigarcia.wdm.WebDriverManager
import core.driver.config.DataDriverProvider
import core.driver.model.DriverConfig

class RemoteDriverFactory() : BaseDriverFactory() {

  override fun setDriverConfig(driverModel: DriverConfig) {
    Configuration.remote =
      "${driverModel.hostRemoteDriver}:${driverModel.portRemoteDriver}"
    super.setDriverConfig(driverModel)
    WebDriverManager.getInstance().setup()
  }
}