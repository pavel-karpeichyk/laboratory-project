package core.holder.static_context_holder

import core.application.app_config.model.AppConfig
import core.holder.Context
import core.holder.ContextHolder

object StaticContextHolder : ContextHolder {

  var appConfig: AppConfig? = null

  override fun <T: Context> getContext() : AppConfig = appConfig ?: throw IllegalArgumentException("Context not " +
      "initialisation")

  override fun clearContext() {
    appConfig = null
  }
}