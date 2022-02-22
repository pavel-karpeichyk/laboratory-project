package core.ui.pages

import com.codeborne.selenide.Selenide.`$`
import core.ui.elements.Hyperlink.getValueHyperlink
import org.openqa.selenium.By

class SearchResultsBlock : BaseBlock() {
  override val baseLocator: By = By.cssSelector("#main div[class^='table'] table tbody")
  private val firstBorrowerId: By = By.cssSelector(" tr td a")

  fun getBorrowerId(): String? {
    return getValueHyperlink(`$`(baseLocator).`$`(firstBorrowerId))
  }
}