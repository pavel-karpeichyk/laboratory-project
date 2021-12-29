package core.context.observer

import core.context.dynamic.SessionContext

class SessionContextObserver(private val sessionContext: SessionContext) : Observer {

  private val cookieName: String = "AuthUser"

  override fun update() {
    val valueFromCookie: String? = sessionContext.serviceResponse?.getValueFromCookie(cookieName)
    if (valueFromCookie != null) {
      sessionContext.authUserTokenValue = valueFromCookie
    }
  }
}
