package core.application.pages

class CRMCollectorsPageXpath {

  val headerBlock = "//div[@class='collapse navbar-collapse in']"

  val buttonMain = "//a[@href='#/']"
  val buttonMain2 = "//a[@ui-sref='dashboard']"

  val buttonLeads = "//a[@href='#/leads']"
  val buttonLeads2 = "//a[@ui-sref='leads']"

  val pageBody = "//*[@id='main']"

  val fieldCollector = "//input[@type='text']"
  val typeArrowList = "//select[@ng-model='params.type']"
  val elementReset = "//*[@id='main']//a[@ng-click='clearFilter()']"
  val buttonSearch = "//*[@id='main']//button[@type='submit']"

  val tableArea = "//div[@class='table-wrapper ng-scope']"
  val columnId = "//td[text()='201']"
  val firstRowTable = "//td[text()='201']/parent::tr"
  val columnName = "//td[text()='201']/following-sibling::td/a"
}