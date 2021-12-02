package core.application.app_config.config

import core.application.app_config.model.AppConfig
import core.holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_LOGIN
import core.holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_PASSWORD
import core.util.YAMLreader
import java.lang.System.getProperty

class AppConfigProvider {

  private val user: String? = getProperty(SYSTEM_PROPERTY_APP_CONFIG_LOGIN)
  private val pass: String? = getProperty(SYSTEM_PROPERTY_APP_CONFIG_PASSWORD)

  private val filePath: String = "src/test/resources/app_config.yaml"

  fun getAppConfig(): AppConfig {
    val config = YAMLreader.readConfig(filePath, AppConfig::class.java)
    if (user != null) {
      config.user = user
    }
    if (pass != null) {
      config.pass = pass
    }
    return config
  }
}