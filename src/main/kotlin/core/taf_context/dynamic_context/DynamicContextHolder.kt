package core.taf_context.dynamic_context

import core.holder.ContextHolder

object DynamicContextHolder : ContextHolder<DynamicContext> {

  override var tafContext: DynamicContext? = null




}