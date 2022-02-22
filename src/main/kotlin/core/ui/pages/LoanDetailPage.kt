package core.ui.pages

class LoanDetailPage : BasePage() {

  override val url: String = "https://mmes-master.idfaws.com/client-area/#/loan-detail"

  fun getPageUrl(): String {
    return url
  }
}