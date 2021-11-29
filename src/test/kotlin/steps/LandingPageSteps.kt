package steps

import core.application.pages.LandingPage

class LandingPageSteps {

  private val landingPage: LandingPage by lazy {LandingPage()}

  fun fillCalculatorForm(amount: String, loanDays: String): LandingPage {
    return landingPage.apply {
      setLoanAmount(amount)
      setLoanPeriod(loanDays)
    }
  }

  fun clickRequestButton(){
    landingPage.clickRequestButton()
  }
}