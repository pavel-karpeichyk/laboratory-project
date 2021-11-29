package steps

import core.application.pages.LandingPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class LandingPageSteps {

  private val landingPage: LandingPage by lazy {LandingPage()}
  private val logger: Logger = LogManager.getLogger()

  fun openLandingPage(){
    LandingPage().openPage()
    logger.info("Open Landing Page")
  }

  fun clickAcceptCoockiesButton(){
    LandingPage().clickAcceptCoockiesButton()
    logger.info("Click Accept Coockies Button")
  }

  fun fillCalculatorForm(amount: String, loanDays: String): LandingPage {
    return landingPage.apply {
      setLoanAmount(amount)
      logger.info("Set loan amount - $amount ")
      setLoanPeriod(loanDays)
      logger.info("Set loan period - $loanDays days")
    }
  }

  fun clickRequestButton(){
    landingPage.clickRequestButton()
    logger.info("Click request button ")
  }
}