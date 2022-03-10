package steps

import core.ui.pages.BorrowersPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BorrowersPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val borrowersPage: BorrowersPage by lazy { BorrowersPage() }

  fun openCrmBorrowersPage() {
    logger.info("Open borrowers page")
    with(borrowersPage) {
      openPage()
      verifyPageOpened()
    }
  }

  fun searchBorrowerUsingFilterAndGetBorrowerId(): String {
    logger.info("Search borrower using filter and get borrower id")
    borrowersPage.run {
      filterSearchBlock.clickSearchButton()
      return searchResultsBlock.getBorrowerId()
    }
  }
}