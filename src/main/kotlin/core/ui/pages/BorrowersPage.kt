package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`

class BorrowersPage : BasePage() {

  override val url: String = "$baseUrl/secure/new-admin/index.html#/borrowers"
  val filterSearchBlock: FilterSearchBlock by lazy { FilterSearchBlock() }
  val searchResultBlock: SearchResultsBlock by lazy { SearchResultsBlock() }

  override fun verifyPageOpened() {
    `$`(filterSearchBlock.searchButton).shouldBe(Condition.visible)
  }
}