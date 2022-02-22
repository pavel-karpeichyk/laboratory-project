package core.ui.pages

import core.context.staticContext

class BorrowersPage : BasePage() {

  override val url: String = staticContext.getBorrowersUiUrl()
  val filterSearchBlock: FilterSearchBlock by lazy { FilterSearchBlock() }
  val searchResultBlock: SearchResultsBlock by lazy { SearchResultsBlock() }
}