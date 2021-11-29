package core.driver.factory

import core.driver.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class FirefoxDriverFactory: BaseDriverFactory() {

  override fun setDriverConfig(driveModel: DriverConfig) {
    super.setDriverConfig(driveModel)
    WebDriverManager.firefoxdriver().setup()
  }
}