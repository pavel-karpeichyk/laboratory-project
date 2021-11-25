package task_1064.core.steps

import task_1064.core.application.pages.LandPage

class CommonSteps {

  fun fillCalculatorForm(amount: String, loanDays: String): LandPage{
    LandPage().setLoanAmount(amount)
    LandPage().setLoanPeriod(loanDays)
    return LandPage()
  }
}