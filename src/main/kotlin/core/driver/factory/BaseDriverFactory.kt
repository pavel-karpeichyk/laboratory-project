package core.driver.factory

import com.codeborne.selenide.Configuration
import core.driver.model.DriverConfig

abstract class BaseDriverFactory : DriverFactory {

  override fun setDriverConfig(driveModel: DriverConfig) {
    Configuration.browser = driveModel.browserType.name
    Configuration.timeout = driveModel.timeout
    Configuration.browserSize = driveModel.browserScreenSize
  }
}