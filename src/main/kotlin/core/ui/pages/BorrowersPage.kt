package core.ui.pages

class BorrowersPage : BasePage() {

  override val url: String = "$baseUrl/secure/new-admin/index.html#/borrowers"
  val filterSearchBlock: FilterSearchBlock by lazy { FilterSearchBlock() }
  val searchResultBlock: SearchResultsBlock by lazy { SearchResultsBlock() }

  override fun verifyPageOpened() {
    filterSearchBlock.verifyBlockDisplayed()
  }
}