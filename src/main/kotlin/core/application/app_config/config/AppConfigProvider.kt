package core.application.app_config.config

import core.application.app_config.model.AppConfig
import core.holder.static_context_holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_LOGIN
import core.holder.static_context_holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_PASSWORD
import core.util.YAMLreader
import java.lang.System.getProperty

class AppConfigProvider {

  private val filePath: String = "src/test/resources/app_config.yaml"
  private val config = YAMLreader.readConfig(filePath, AppConfig::class.java)

  fun getAppConfig(): AppConfig {
    config.user = getProperty(SYSTEM_PROPERTY_APP_CONFIG_LOGIN) ?: config.user
    config.pass = getProperty(SYSTEM_PROPERTY_APP_CONFIG_PASSWORD) ?: config.pass
    return config
  }
}
