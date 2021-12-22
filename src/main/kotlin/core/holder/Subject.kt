package core.holder

interface Subject {
  fun registerObserver(observer: Observer)
  fun unregisterObserver(observer: Observer)
  fun notifyObserver()
}