package core.holder

interface ContextHolder {

  fun <T: Context> getContext(): Context
  fun clearContext()
}