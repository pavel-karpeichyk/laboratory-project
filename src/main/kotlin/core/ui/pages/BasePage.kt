package core.ui.pages

import com.codeborne.selenide.Selenide.open
import core.context.staticContext

abstract class BasePage {
  protected abstract val url: String
  protected  val baseUrl = staticContext.getBaseUrl()

  fun openPage() {
    open(url)
  }

  fun getPageUrl(): String {
    return url
  }

  abstract fun verifyPageOpened()
}