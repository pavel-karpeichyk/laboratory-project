package core.holder

import core.api.HTTPclient.TafResponse

class DynamicContext : Subject {

  private var observers: ArrayList<Observer> = ArrayList()

  var sessionContext: SessionContext = SessionContext()
  var userValue: String? = null

  fun setNewCondition(newCondition: TafResponse){
    sessionContext.serviceResponse=newCondition
    notifyObserver()
  }

  override fun registerObserver(observer: Observer) {
    observers.add(observer)
  }

  override fun unregisterObserver(observer: Observer) {
    observers.remove(observer)
  }

  override fun notifyObserver(){
    for(observer in observers)
      observer.update(userValue!!)
  }
}