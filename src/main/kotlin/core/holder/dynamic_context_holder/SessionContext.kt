package core.holder.dynamic_context_holder

import core.api.http.TafResponse
import core.api.observer.Observable
import core.api.observer.Observer
import core.api.observer.SessionContextObserver

class SessionContext() : Observable {

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