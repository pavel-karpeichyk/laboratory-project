package steps

import core.ui.pages.BorrowersPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BorrowersPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val borrowersPage: BorrowersPage by lazy { BorrowersPage() }

  private fun openPage() {
    logger.info("Open borrowers page")
    borrowersPage.openPage()
  }

  private fun getBorrowersTable() {
    logger.info("Open borrowers table")
    borrowersPage.apply {
      filterSearchBlock.clickSearchButton()
    }
  }

  fun getBorrowerId(): String? {
    borrowersPage.apply {
    openPage()
    verifyPageOpened()
    getBorrowersTable()
    return searchResultBlock.getBorrowerId()
  }
  }
}