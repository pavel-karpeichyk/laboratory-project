package core.ui.pages

import com.codeborne.selenide.Selenide.`$`
import core.ui.elements.Hyperlink.getHyperlinkValue
import org.openqa.selenium.By

class SearchResultsBlock : BaseBlock() {

  override val baseBlockLocator: By = By.cssSelector("#main div[class^='table'] table tbody")
  private val firstBorrowerId: By = By.cssSelector(" tr td a")

  fun getBorrowerId(): String? {
    return getHyperlinkValue(`$`(baseBlockLocator).`$`(firstBorrowerId))
  }
}