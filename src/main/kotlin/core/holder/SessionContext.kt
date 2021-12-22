package core.holder

import core.api.HTTPclient.TafResponse

class SessionContext : Subject {
  var serviceResponse: TafResponse? = null

    set(value) {
      field = value
       notifyObserver()
    }
  var authUserTokenValue: String? = null

  override fun registerObserver(observer: Observer) {
    TODO("Not yet implemented")
  }

  override fun unregisterObserver(observer: Observer) {
    TODO("Not yet implemented")
  }

  override fun notifyObserver() {
    if(serviceResponse?.getValueFromCookie("widwu")!=null){
       authUserTokenValue = serviceResponse?.getValueFromCookie("widwu")
    }
  }
}