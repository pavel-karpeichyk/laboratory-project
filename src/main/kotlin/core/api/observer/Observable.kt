package core.api.observer

interface Observable {
  fun registerObserver(observer: Observer)
  fun unregisterObserver(observer: Observer)
  fun notifyObserver()
}