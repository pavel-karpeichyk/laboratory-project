package core.driver.provider

import core.driver.config.DataDriverProvider
import core.driver.factory.ChromeDriverFactory
import core.driver.factory.FirefoxDriverFactory
import core.driver.factory.RemoteDriverFactory
import core.driver.model.DriverConfig
import core.driver.provider.BrowserType.CHROME
import core.driver.provider.BrowserType.FIREFOX

class DriverConfigProvider {

  private val driveModel: DriverConfig = DataDriverProvider().getConfig()

  fun getDriverFactory() {

    when (driveModel.driverType) {
      DriverType.LOCAL ->
        when (driveModel.browserType) {
          CHROME -> ChromeDriverFactory().setDriverConfig(driveModel)
          FIREFOX -> FirefoxDriverFactory().setDriverConfig(driveModel)
        }
      DriverType.REMOTE -> RemoteDriverFactory().setDriverConfig(driveModel)
    }
  }
}