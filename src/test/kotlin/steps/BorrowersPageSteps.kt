package steps

import core.ui.pages.BorrowersPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BorrowersPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val borrowersPage: BorrowersPage by lazy { BorrowersPage() }

  fun getBorrowerId(): String {
    logger.info("Get borrower id")
    borrowersPage.apply {
      openPage()
      verifyPageOpened()
      filterSearchBlock.clickSearchButton()
      return searchResultBlock.getBorrowerId()
    }
  }
}