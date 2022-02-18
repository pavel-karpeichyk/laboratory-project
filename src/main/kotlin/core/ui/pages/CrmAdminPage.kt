package core.ui.pages

import core.ui.elements.Button.clickButton
import core.ui.elements.Hyperlink.clickHyperlink
import org.openqa.selenium.By

class CrmAdminPage {

  private val menuButton: By = By.xpath("//*[@id='header']//button[@type='button']")
  private val borrowersLink: By = By.xpath("//a[@ui-sref='borrowers']")

  fun clickMenuButton() {
    clickButton(menuButton)
  }

  fun clickBorrowersLink() {
    clickHyperlink(borrowersLink)
  }
}