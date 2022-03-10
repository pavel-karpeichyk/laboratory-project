package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class LoanDetailPage : BasePage() {

  override val url: String = "$baseUrl/client-area/#/loan-detail"
  private val myCreditHyperlink : By = By.cssSelector("a[aria-current='page']")

  override fun verifyPageOpened() {
    `$`(myCreditHyperlink).shouldBe(Condition.visible)
  }
}