package tasks.locators

import org.openqa.selenium.By

class PageBodyBlock: BaseBlock() {
  override val baseLocator: By = By.id("main")
  val fieldCollector: By = By.cssSelector("input[type='text']")
  val arrowInTypeDropDown: By = By.cssSelector("select[ng-model='params.type']")
  val elementReset: By = By.cssSelector("a[ng-click='clearFilter()']")
  val buttonSearch: By = By.cssSelector("button[type='submit']")
}
