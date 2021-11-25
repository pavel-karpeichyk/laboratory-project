package task_1064.steps

import task_1064.core.application.pages.LandingPage

class LandingPageSteps {

  fun fillCalculatorForm(amount: String, loanDays: String): LandingPage{
    return LandingPage().apply {
    LandingPage().setLoanAmount(amount)
    LandingPage().setLoanPeriod(loanDays)
    }
  }
}