package steps

import core.application.pages.LandingPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class LandingPageSteps {

  private val landingPage: LandingPage by lazy { LandingPage() }
  private val logger: Logger = LogManager.getLogger()

  fun openLandingPage() {
    logger.info("Open Landing Page")
    LandingPage().openPage()
  }

  fun clickAcceptCoockiesButton() {
    logger.info("Click Accept Coockies Button")
    LandingPage().clickAcceptCoockiesButton()
  }

  fun fillCalculatorForm(amount: String, loanDays: String): LandingPage {
    return landingPage.apply {
      logger.info("Set loan amount - $amount ")
      setLoanAmount(amount)
      logger.info("Set loan period - $loanDays days")
      setLoanPeriod(loanDays)
    }
  }

  fun clickRequestButton() {
    logger.info("Click request button ")
    landingPage.clickRequestButton()
  }
}