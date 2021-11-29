package core.driver.provider

import core.driver.config.DataDriverProvider
import core.driver.factory.ChromeDriverFactory
import core.driver.factory.DriverFactory
import core.driver.factory.FirefoxDriverFactory
import core.driver.factory.RemoteDriverFactory
import core.driver.model.DriverConfig
import core.driver.provider.BrowserType.CHROME
import core.driver.provider.BrowserType.FIREFOX
import core.driver.provider.DriverType.LOCAL
import core.driver.provider.DriverType.REMOTE

class DriverConfigProvider {

  private val driverModel: DriverConfig = DataDriverProvider().getConfig()

  fun setDriverConfig() {
    var driverFactory: DriverFactory =  when (driverModel.driverType) {
      LOCAL -> {
         when (driverModel.browserType) {
          CHROME -> ChromeDriverFactory()
          FIREFOX -> FirefoxDriverFactory()
        }
      }
      REMOTE -> RemoteDriverFactory()
    }
      driverFactory.setDriverConfig(driverModel)
  }
}