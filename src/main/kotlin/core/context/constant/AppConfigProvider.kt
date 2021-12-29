package core.context.constant

import core.reader.YAMLreader
import core.taf_properties.SystemProperties.SYSTEM_PROPERTY_APP_CONFIG_LOGIN
import core.taf_properties.SystemProperties.SYSTEM_PROPERTY_APP_CONFIG_PASSWORD
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
