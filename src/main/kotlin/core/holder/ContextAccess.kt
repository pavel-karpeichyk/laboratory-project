package core.holder

import core.application.app_config.model.AppConfig
import core.taf_context.dynamic_context.DynamicContext
import core.taf_context.dynamic_context.DynamicContextHolder
import core.taf_context.static_context.StaticContextHolder

val staticContext: AppConfig = StaticContextHolder.getContext()
val dynamicContext: DynamicContext = DynamicContextHolder.getContext()