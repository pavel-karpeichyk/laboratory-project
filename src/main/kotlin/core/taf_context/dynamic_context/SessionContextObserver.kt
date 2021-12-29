package core.taf_context.dynamic_context

import core.api.observer.Observer

class SessionContextObserver(private val sessionContext: SessionContext) : Observer {

  private val cookieName: String = "AuthUser"

  override fun update() {
    val valueFromCookie: String? = sessionContext.serviceResponse?.getValueFromCookie(cookieName)
    if (valueFromCookie != null) {
      sessionContext.authUserTokenValue = valueFromCookie
    }
  }
}
