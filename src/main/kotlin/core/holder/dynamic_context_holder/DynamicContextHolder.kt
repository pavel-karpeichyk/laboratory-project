package core.holder.dynamic_context_holder


import core.holder.Context
import core.holder.ContextHolder

object DynamicContextHolder : ContextHolder {

  var dynamicConfig: DynamicContext? = null

  override fun <T: Context> getContext(): DynamicContext = dynamicConfig ?: throw IllegalArgumentException(
    "Context not initialisation")

  override fun clearContext() {
    dynamicConfig = null
  }
}