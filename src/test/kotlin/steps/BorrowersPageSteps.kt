package steps

import core.ui.pages.BorrowersPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class BorrowersPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val borrowersPage: BorrowersPage by lazy { BorrowersPage() }

  private fun openPage(){
    borrowersPage.openPage()
  }

  private fun getBorrowersTable() {
    logger.info("Open borrowers table")
    borrowersPage.apply {
      filterSearchBlock.clickSearchButton()
    }
  }

  fun getIdBorrower() : String?{
    return  with(BorrowersPageSteps()){
      openPage()
      getBorrowersTable()
      borrowersPage.searchResultBlock.getBorrowerId()
    }
  }

}