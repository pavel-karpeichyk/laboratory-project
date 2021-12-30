package core.ui.driver.factory

import core.ui.driver.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeDriverFactory : BaseDriverFactory() {

  override fun setDriverConfig(driverModel: DriverConfig) {
    super.setDriverConfig(driverModel)
    WebDriverManager.chromedriver().setup()
  }
}