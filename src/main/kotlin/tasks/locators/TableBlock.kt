package tasks.locators

import org.openqa.selenium.By

class TableBlock: BaseBlock(){
  override val baseLocator: By = By.cssSelector("div[class='table-wrapper ng-scope']")
  val columnId : By = By.xpath("//td[text()='201']")
  val firstRowTable: By = By.xpath( "//td[text()='201']/parent::tr")
  val columnName : By = By.xpath( "//td[text()='201']/following-sibling::td/a")
}