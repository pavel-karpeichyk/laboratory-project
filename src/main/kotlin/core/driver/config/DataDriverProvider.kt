package core.driver.config

import core.driver.model.DriverConfig
import core.util.YAMLreader

open class DataDriverProvider {

  private val filePath: String = "src/main/resources/driverConfig.yaml"

  fun getConfig(): DriverConfig {
    return YAMLreader.readConfig(filePath, DriverConfig::class.java)
  }
}