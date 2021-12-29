package core.holder

import core.taf_context.TafContext

interface ContextHolder<T : TafContext> {

  var tafContext: T?

  fun getContext(): T {
    return tafContext ?: throw IllegalArgumentException("Context not initialisation")
  }

  fun clearContext() {
    tafContext = null
  }
}