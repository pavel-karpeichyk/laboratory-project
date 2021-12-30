package core.context.observer

interface Observable {

  var observers: ArrayList<Observer>

  fun registerObserver(observer: Observer) {
    observers.add(observer)
  }

  fun unregisterObserver(observer: Observer) {
    observers.remove(observer)
  }

  fun notifyObserver() {
    observers.forEach { it.update() }
  }
}