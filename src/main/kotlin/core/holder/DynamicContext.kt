package core.holder

class DynamicContext {

  val sessionContext: SessionContext  by lazy { SessionContext() }
}