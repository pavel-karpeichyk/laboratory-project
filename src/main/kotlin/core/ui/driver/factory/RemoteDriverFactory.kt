package core.ui.driver.factory

import com.codeborne.selenide.Configuration
import core.ui.driver.model.DriverConfig

class RemoteDriverFactory : BaseDriverFactory() {

  override fun setDriverConfig(driverModel: DriverConfig) {
    Configuration.remote =
      "${driverModel.hostRemoteDriver}:${driverModel.portRemoteDriver}"
    super.setDriverConfig(driverModel)
  }
}