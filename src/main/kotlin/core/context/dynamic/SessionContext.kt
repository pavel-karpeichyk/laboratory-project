package core.context.dynamic

import core.context.observer.Observable
import core.context.observer.Observer
import core.context.observer.SessionContextObserver
import core.http.response.TafResponse

class SessionContext : Observable {

  override var observers: ArrayList<Observer> = ArrayList()

  init {
    this.registerObserver(SessionContextObserver(this))
  }

  var authUserTokenValue: String? = null
  var serviceResponse: TafResponse? = null
    set(value) {
      field = value
      notifyObserver()
    }
}