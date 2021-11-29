package steps

import core.application.pages.LandingPage

class LandingPageSteps {

  fun fillCalculatorForm(amount: String, loanDays: String): LandingPage{
    return LandingPage().apply {
    LandingPage().setLoanAmount(amount)
    LandingPage().setLoanPeriod(loanDays)
    }
  }
}