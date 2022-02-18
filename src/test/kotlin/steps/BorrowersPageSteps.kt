package steps

import core.ui.pages.BorrowersPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BorrowersPageSteps {

  private val borrowersPage: BorrowersPage by lazy { BorrowersPage() }
  private val logger: Logger = LogManager.getLogger()

  fun getBorrowersTable() {
    logger.info("Open borrowers table")
    borrowersPage.apply {
      clickSearchButton()
    }
  }

  fun getIdBorrower() : String?{
    CrmLoginPageSteps().crmLogin()
    CrmAdminPageSteps().switchToBorrowersPage()
    BorrowersPageSteps().getBorrowersTable()
  return  BorrowersPage().getBorrowerId()
  }

}