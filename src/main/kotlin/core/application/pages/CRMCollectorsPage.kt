package core.application.pages

import org.openqa.selenium.By

class CRMCollectorsPage {

  class HeaderBlock : BaseBlock() {
    override val baseLocator: By = By.cssSelector("div[class='collapse navbar-collapse in']")
    val buttonMain: By = By.cssSelector("a[href='#/']")
    val buttonLeads: By = By.cssSelector("a[href='#/leads']")
  }

  class PageBodyBlock : BaseBlock() {
    override val baseLocator: By = By.id("main")
    val fieldCollector: By = By.cssSelector("input[type='text']")
    val arrowInTypeDropDown: By = By.cssSelector("select[ng-model='params.type']")
    val elementReset: By = By.cssSelector("#main a[ng-click='clearFilter()']")
    val buttonSearch: By = By.cssSelector("#main button[type='submit']")
  }

  class TableBlock : BaseBlock(){
    override val baseLocator: By=By.cssSelector("div[class='table-wrapper ng-scope']")
    val columnId : By=By.xpath("//td[text()='201']")
    val firstRowTable: By =By.xpath( "//td[text()='201']/parent::tr")
    val columnName : By=By.xpath( "//td[text()='201']/following-sibling::td/a")

  }
}