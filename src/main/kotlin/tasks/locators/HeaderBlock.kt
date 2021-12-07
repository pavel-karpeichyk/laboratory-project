package tasks.locators

import org.openqa.selenium.By

class HeaderBlock:BaseBlock() {
  override val baseLocator: By = By.cssSelector("div[class='collapse navbar-collapse in']")
  val buttonMain: By = By.cssSelector("a[href='#/']")
  val buttonLeads: By = By.cssSelector("a[href='#/leads']")
}