package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.staticContext

class BorrowersPage : BasePage() {

  private val baseUrl: String = staticContext.getBaseUrl()
  override val url: String = "$baseUrl/secure/new-admin/index.html#/borrowers"
  val filterSearchBlock: FilterSearchBlock by lazy { FilterSearchBlock() }
  val searchResultBlock: SearchResultsBlock by lazy { SearchResultsBlock() }

  override fun verifyPageOpened() {
   `$`(filterSearchBlock.searchButton).shouldBe(Condition.visible)
  }
}