package core.ui.driver.provider

import core.reader.YAMLreader
import core.taf_properties.SystemProperties.BROWSER_TYPE_SYSTEM_PROPERTY_NAME
import core.ui.driver.BrowserType
import core.ui.driver.model.DriverConfig
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