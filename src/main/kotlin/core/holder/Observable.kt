package core.holder

interface Observable {
  fun registerObserver(observer: Observer)
  fun unregisterObserver(observer: Observer)
  fun notifyObserver()
}