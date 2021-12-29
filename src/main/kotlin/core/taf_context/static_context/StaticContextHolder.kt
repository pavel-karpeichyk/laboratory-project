package core.taf_context.static_context

import core.application.app_config.model.AppConfig
import core.holder.ContextHolder

object StaticContextHolder : ContextHolder<AppConfig> {

  override var tafContext: AppConfig? = null
}