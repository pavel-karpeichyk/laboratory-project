package core.taf_context.dynamic_context

import core.taf_context.TafContext

class DynamicContext : TafContext {

  val sessionContext: SessionContext by lazy { SessionContext() }
}