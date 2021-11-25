package task_1064.core.application.app_config.config

import task_1064.core.application.app_config.model.AppConfig
import task_1064.core.util.YAMLreader

class AppConfigProvider {

private  val filePath: String= "src/test/resources/app_config.yaml"

  fun getAppConfig(): AppConfig {
    return YAMLreader.readConfig(filePath, AppConfig::class.java)
  }
}