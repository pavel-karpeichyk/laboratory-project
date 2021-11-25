package task_1064.driver.factory

import com.codeborne.selenide.Configuration
import task_1064.driver.config.DataDriverProvider
import task_1064.driver.model.DriverConfig

class BaseDriverFactory: DriverFactory{

  private val driveModel: DriverConfig = DataDriverProvider().getConfig()

  override fun setDriverConfig(dataDriverConfig: DataDriverProvider) {
    Configuration.browser= dataDriverConfig.getConfig().browserType
    Configuration.timeout = driveModel.timeout
    Configuration.browserSize = driveModel.browserScreenSize
  }
}