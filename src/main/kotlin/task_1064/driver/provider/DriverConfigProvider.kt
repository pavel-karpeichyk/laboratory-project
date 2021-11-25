package task_1064.driver.provider

import task_1064.driver.config.DataDriverProvider
import task_1064.driver.factory.ChromeDriverFactory
import task_1064.driver.factory.FirefoxDriverFactory
import task_1064.driver.factory.RemoteDriverFactory
import task_1064.driver.model.DriverConfig
import task_1064.driver.provider.BrowserType.CHROME
import task_1064.driver.provider.BrowserType.FIREFOX

 class DriverConfigProvider {

   private  val driveModel: DriverConfig = DataDriverProvider().getConfig()

  fun getDriverFactory(dataDriverConfig: DataDriverProvider) {
    when (driveModel.driverType) {
      DriverType.LOCAL.name->
      when (driveModel.browserType) {
        CHROME.name -> ChromeDriverFactory().setDriverConfig(dataDriverConfig)
        FIREFOX.name -> FirefoxDriverFactory().setDriverConfig(dataDriverConfig)
      }
      DriverType.REMOTE.name -> RemoteDriverFactory().setDriverConfig(dataDriverConfig)
    }
  }
}