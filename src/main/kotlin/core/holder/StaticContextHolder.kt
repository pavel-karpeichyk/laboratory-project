package core.holder

import core.application.app_config.model.AppConfig

object StaticContextHolder : ContextHolder {

  var appConfic: AppConfig? = null

  override fun clearContext() {
    appConfic = null
  }
}