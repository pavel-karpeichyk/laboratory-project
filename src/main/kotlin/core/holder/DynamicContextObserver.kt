package core.holder

class DynamicContextObserver() : Observer {

  fun following(dynamicContext: DynamicContext) {
    dynamicContext.registerObserver(this)
  }

  var value: String? = null

  override fun update(userValue: String) {
    DynamicContext().userValue = userValue
  }
}
