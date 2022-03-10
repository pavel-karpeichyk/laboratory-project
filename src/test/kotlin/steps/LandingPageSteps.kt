package steps

import core.ui.pages.LandingPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class LandingPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val landingPage: LandingPage by lazy { LandingPage() }

  fun openLandingPage() {
    logger.info("Open Landing Page")
    landingPage.openPage()
  }

  fun clickAcceptCoockiesButton(): LandingPage {
    logger.info("Click Accept Coockies Button")
    return landingPage.apply {
      clickAcceptCookiesButton()
      verifyRequestLoanButtonIsDisplayed()
    }
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