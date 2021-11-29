package core.driver.factory

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Configuration.browser
import com.codeborne.selenide.Configuration.browserSize
import com.codeborne.selenide.Configuration.timeout
import core.driver.model.DriverConfig

abstract class BaseDriverFactory : DriverFactory {

  override fun setDriverConfig(driverModel: DriverConfig) {
    Configuration().apply {
      browser = driverModel.browserType.name
      timeout = driverModel.timeout
      browserSize = driverModel.browserScreenSize
    }
  }
}