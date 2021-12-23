package core.holder

import core.api.HTTPclient.TafResponse

class SessionContext : Observable {

  private var observers: ArrayList<Observer> = ArrayList()
  private val cookieName = "AuthUser"
  var authUserTokenValue: String? = null
  var serviceResponse: TafResponse? = null
    set(value) {
      field = value
      notifyObserver()
    }

  fun getNameCookie() = cookieName

  init {
    this.registerObserver(SessionContextObserver(this))
  }

  override fun registerObserver(observer: Observer) {
    observers.add(observer)
  }

  override fun unregisterObserver(observer: Observer) {
    observers.remove(observer)
  }

  override fun notifyObserver() {
    observers.forEach { it.update() }
  }
}