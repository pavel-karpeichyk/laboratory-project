package selenide

import core.TestBase
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

import pages.GoogleSearchPage
import pages.GoogleSearchResultPage

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SearchTest : TestBase() {

  @Test
  fun `search text test`(){
    var searchText: String = "Selenide"
    GoogleSearchPage().search(searchText)
    GoogleSearchResultPage().`verify search result`("Selenide")
  }
}