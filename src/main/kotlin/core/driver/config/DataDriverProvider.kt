package core.driver.config

import core.util.YAMLreader
import core.driver.model.DriverConfig

open class DataDriverProvider {

  private val filePath: String = "src/main/resources/driverConfig.yaml"

  fun getConfig(): DriverConfig {
    return YAMLreader.readConfig(filePath, DriverConfig::class.java)
  }
}