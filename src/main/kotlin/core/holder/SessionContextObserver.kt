package core.holder

class SessionContextObserver(private val sessionContext: SessionContext) : Observer {

  override fun update() {
    val valueCookie: String? = sessionContext.serviceResponse?.getValueFromCookie(sessionContext.getNameCookie())
    if (valueCookie != null) {
      sessionContext.authUserTokenValue = valueCookie
    }
  }
}
