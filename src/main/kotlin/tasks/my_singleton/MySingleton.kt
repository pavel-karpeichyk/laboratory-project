package tasks.my_singleton

class MySingleton private constructor() {
  companion object {
    private var instance: MySingleton? = null

    fun getInstance(): MySingleton {
      if (instance == null) {
        instance = MySingleton()
      }
      return instance!!
    }
  }
}