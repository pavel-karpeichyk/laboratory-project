package core.ui.driver.setter

import core.ui.driver.BrowserType.CHROME
import core.ui.driver.BrowserType.FIREFOX
import core.ui.driver.DriverType.LOCAL
import core.ui.driver.DriverType.REMOTE
import core.ui.driver.factory.ChromeDriverFactory
import core.ui.driver.factory.DriverFactory
import core.ui.driver.factory.FirefoxDriverFactory
import core.ui.driver.factory.RemoteDriverFactory
import core.ui.driver.model.DriverConfig
import core.ui.driver.provider.DataDriverProvider

class DriverConfigSetter {

  private val driverModel: DriverConfig = DataDriverProvider().getConfig()

  fun setDriverConfig() {
    var driverFactory: DriverFactory = when (driverModel.driverType) {
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