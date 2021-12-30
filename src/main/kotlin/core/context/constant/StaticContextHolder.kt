package core.context.constant

import core.context.ContextHolder

object StaticContextHolder : ContextHolder<AppConfig> {

  override var tafContext: AppConfig? = null
}