package task_1064.driver.config

import task_1064.core.util.YAMLreader
import task_1064.driver.model.DriverConfig

open class DataDriverProvider {

  private val filePath: String = "src/main/resources/driverConfig.yaml"

  fun getConfig(): DriverConfig {
    return YAMLreader.readConfig(filePath, DriverConfig::class.java)
  }
}