package core.ui.pages

import core.context.staticContext

class LoanDetailPage : BasePage() {
  private val baseUrl: String = staticContext.getBaseUrl()
  override val url: String = "$baseUrl/client-area/#/loan-detail"

  override fun verifyPageOpened() {
    TODO("Not yet implemented")
  }
}