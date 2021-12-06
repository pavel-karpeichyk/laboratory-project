package core.driver.config

import core.driver.model.DriverConfig
import core.driver.provider.BrowserType
import core.holder.SystemPropertiesHolder.BROWSER_TYPE_SYSTEM_PROPERTY_NAME
import core.util.YAMLreader
import java.lang.System.getProperty

open class DataDriverProvider {

  private val filePath: String = "src/main/resources/driverConfig.yaml"

  fun getConfig(): DriverConfig {
    val config: DriverConfig = YAMLreader.readConfig(filePath, DriverConfig::class.java)

    getProperty(BROWSER_TYPE_SYSTEM_PROPERTY_NAME)?.let { browserTypeSystemProperty ->
      config.browserType = BrowserType.valueOf(browserTypeSystemProperty)
    }

    return config
  }
}