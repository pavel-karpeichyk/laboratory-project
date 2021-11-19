package custom_elements

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Table (element: WebElement){

  var webTable: WebElement=element

  fun getRowsNumber(): Int{
    var tableRows: List <WebElement> = webTable.findElements(By.tagName("tr"))
    return tableRows.size
  }

  fun getColumnNumber(): Int{
    var firstRaw: WebElement= webTable.findElement(By.tagName("tr"))
    var tableColumns: List <WebElement> =firstRaw.findElements(By.tagName("td"))
    return tableColumns.size
  }

  fun getCellContent(columnIndex: Int, rowIndex: Int): String {
    var tableRows: List <WebElement> = webTable.findElements(By.tagName("tr"))
    var currentRow: WebElement=tableRows.get(rowIndex)

    var tableColumns: List <WebElement> =currentRow.findElements(By.tagName("td"))
    var currentCell: WebElement = tableColumns.get(columnIndex)

    return currentCell.text
  }
}