package core.holder.dynamic_context_holder

import core.holder.Context

class DynamicContext : Context {

  val sessionContext: SessionContext by lazy { SessionContext() }
}