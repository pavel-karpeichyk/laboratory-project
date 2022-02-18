package steps

import core.ui.pages.BorrowersPage
import core.ui.pages.CrmAdminPage
import core.ui.pages.CrmLoginPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class CrmAdminPageSteps {

  private val crmAdminPage: CrmAdminPage by lazy { CrmAdminPage() }
  private val logger: Logger = LogManager.getLogger()

  fun switchToBorrowersPage(){
    logger.info("Switch to borrowers page")
     crmAdminPage.apply {
      clickMenuButton()
      clickBorrowersLink()
    }
  }
}