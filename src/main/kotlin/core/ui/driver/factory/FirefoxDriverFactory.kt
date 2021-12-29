package core.ui.driver.factory

import core.ui.driver.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class FirefoxDriverFactory : BaseDriverFactory() {

  override fun setDriverConfig(driverModel: DriverConfig) {
    super.setDriverConfig(driverModel)
    WebDriverManager.firefoxdriver().setup()
  }
}