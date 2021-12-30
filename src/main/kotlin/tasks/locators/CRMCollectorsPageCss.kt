package tasks.locators

class CRMCollectorsPageCss {

  val headerBlock = "div[class='collapse navbar-collapse in']"

  val buttonMain = "a[href='#/']"
  val buttonMain2 = "a[ui-sref='dashboard']"

  val buttonLeads = "a[href='#/leads']"
  val buttonLeads2 = "a[ui-sref='leads']"

  val pageBody = "#main"

  val fieldCollector = "input[type='text']"
  val typeArrowList = "select[ng-model='params.type']"
  val elementReset = "#main a[ng-click='clearFilter()']"
  val buttonSearch = "#main button[type='submit']"

  val tableArea = "div[class='table-wrapper ng-scope']"
}