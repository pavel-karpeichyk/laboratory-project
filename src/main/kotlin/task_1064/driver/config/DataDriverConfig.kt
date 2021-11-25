package task_1064.driver.config

import task_1064.core.util.YAMLreader
import task_1064.driver.model.DriverConfigModel

open class DataDriverConfig {

  private val filePath: String = "src/main/resources/driverConfig.yaml"

  fun getConfig(): DriverConfigModel {
    return YAMLreader.readConfig(filePath, DriverConfigModel::class.java)
  }
}