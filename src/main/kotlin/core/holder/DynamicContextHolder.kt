package core.holder

import core.application.app_config.model.AppConfig

object DynamicContextHolder: ContextHolder {

  var dynamicConfig: DynamicContext? = null

  override fun getConfig(): DynamicContext = dynamicConfig ?: throw IllegalArgumentException("Context not initialisation")

  override fun clearContext() {
    dynamicConfig = null
  }
}