package task_1064.driver.factory

import io.github.bonigarcia.wdm.WebDriverManager
import task_1064.driver.config.DataDriverProvider

class ChromeDriverFactory : DriverFactory {

  override fun setDriverConfig(dataDriverConfig: DataDriverProvider) {
      BaseDriverFactory().setDriverConfig(dataDriverConfig)
      WebDriverManager.chromedriver().setup()
    }
  }