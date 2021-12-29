package core.context

import core.context.constant.AppConfig
import core.context.constant.StaticContextHolder
import core.context.dynamic.DynamicContext
import core.context.dynamic.DynamicContextHolder

val staticContext: AppConfig = StaticContextHolder.getContext()
val dynamicContext: DynamicContext = DynamicContextHolder.getContext()