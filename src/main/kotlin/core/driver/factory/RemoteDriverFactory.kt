package core.driver.factory

import com.codeborne.selenide.Configuration
import core.driver.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class RemoteDriverFactory() : BaseDriverFactory() {

  override fun setDriverConfig(driverModel: DriverConfig) {
    Configuration.remote =
      "${driverModel.hostRemoteDriver}:${driverModel.portRemoteDriver}"
    super.setDriverConfig(driverModel)
  }
}