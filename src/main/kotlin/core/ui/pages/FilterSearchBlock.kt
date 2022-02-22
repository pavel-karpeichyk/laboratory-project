package core.ui.pages

import com.codeborne.selenide.Selenide.`$`
import core.ui.elements.Button.clickButtonSelenideElement
import org.openqa.selenium.By

class FilterSearchBlock : BaseBlock() {
  override val baseLocator: By = By.cssSelector("form[class='ng-pristine ng-valid']")
  private val searchButton: By = By.cssSelector("button[ng-disabled^='disable']")

  fun clickSearchButton() {
    clickButtonSelenideElement(`$`(baseLocator).`$`(searchButton))
  }
}