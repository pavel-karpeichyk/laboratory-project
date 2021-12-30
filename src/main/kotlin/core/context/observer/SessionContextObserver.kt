package core.context.observer

import core.context.authUserTokenValue
import core.context.dynamic.SessionContext
import core.context.serviceResponse

class SessionContextObserver(private val sessionContext: SessionContext) : Observer {

  private val cookieName: String = "AuthUser"

  override fun update() {
    val valueFromCookie: String? = serviceResponse?.getValueFromCookie(cookieName)
    if (valueFromCookie != null) {
      authUserTokenValue = valueFromCookie
    }
  }
}
