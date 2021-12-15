package core.holder

import core.application.app_config.model.AppConfig

object StaticContextHolder : ContextHolder {

  var appConfig: AppConfig? = null

  override fun getConfig(): AppConfig = appConfig ?: throw IllegalArgumentException("Context not initialisation")

  override fun clearContext() {
    appConfig = null
  }
}