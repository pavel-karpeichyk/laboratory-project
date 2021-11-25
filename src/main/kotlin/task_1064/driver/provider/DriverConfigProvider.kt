package task_1064.driver.provider

import task_1064.driver.config.DataDriverConfig
import task_1064.driver.factory.ChromeDriverFactory
import task_1064.driver.factory.FirefoxDriverFactory
import task_1064.driver.factory.RemoteDriverFactory
import task_1064.driver.model.DriverConfigModel
import task_1064.driver.provider.BrowserType.CHROME
import task_1064.driver.provider.BrowserType.FIREFOX

 class DriverConfigProvider {

   private  val driveModel: DriverConfigModel = DataDriverConfig().getConfig()

  fun getDriverFactory(dataDriverConfig: DataDriverConfig) {
    when (driveModel.driverType) {
      DriverType.LOCAL.name->
      when (driveModel.browserType) {
        CHROME.name -> ChromeDriverFactory().getContent(dataDriverConfig)
        FIREFOX.name -> FirefoxDriverFactory().getContent(dataDriverConfig)
      }
      DriverType.REMOTE.name -> RemoteDriverFactory().getContent(dataDriverConfig)
    }
  }
}