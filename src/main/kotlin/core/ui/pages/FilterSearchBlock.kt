package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.ui.elements.Button.clickButton
import org.openqa.selenium.By

class FilterSearchBlock : BaseBlock() {

  override val baseBlockLocator: By = By.cssSelector("form[class='ng-pristine ng-valid']")
  private val searchButton: By = By.cssSelector("button[ng-disabled^='disable']")

  fun clickSearchButton() {
    clickButton(`$`(baseBlockLocator).`$`(searchButton))
  }

  fun verifyBlockDisplayed() {
    `$`(searchButton).shouldBe(Condition.visible)
  }
}