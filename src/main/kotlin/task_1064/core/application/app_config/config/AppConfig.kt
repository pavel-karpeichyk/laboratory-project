package task_1064.core.application.app_config.config

import task_1064.core.application.app_config.model.AppConfigModel
import task_1064.core.util.YAMLreader

class AppConfig {

private  val filePath: String= "src/test/resources/app_config.yaml"

  fun getAppConfig(): AppConfigModel {
    return YAMLreader.readConfig(filePath, AppConfigModel::class.java)
  }
}