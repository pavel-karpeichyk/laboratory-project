package core.context.dynamic

import core.context.ContextHolder

object DynamicContextHolder : ContextHolder<DynamicContext> {

  override var tafContext: DynamicContext? = null
}