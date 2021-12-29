package core.context.dynamic

import core.context.TafContext

class DynamicContext : TafContext {

  val sessionContext: SessionContext by lazy { SessionContext() }
}