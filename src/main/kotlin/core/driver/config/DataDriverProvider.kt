package core.driver.config

import core.driver.model.DriverConfig
import core.driver.provider.BrowserType
import core.holder.SystemPropertiesHolder.BROWSER_TYPE_SYSTEM_PROPERTY_NAME
import core.util.YAMLreader
import java.lang.System.getProperty

open class DataDriverProvider {
  private val browserType: BrowserType? =
    getProperty(BROWSER_TYPE_SYSTEM_PROPERTY_NAME)?.let { BrowserType.valueOf(it) }

  private val filePath: String = "src/main/resources/driverConfig.yaml"

  fun getConfig(): DriverConfig {
    val config: DriverConfig = YAMLreader.readConfig(filePath, DriverConfig::class.java)
    if (browserType != null) {
      config.browserType = browserType
    }
    return config
  }
}