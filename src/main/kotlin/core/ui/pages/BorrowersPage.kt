package core.ui.pages

import com.codeborne.selenide.CollectionCondition
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import core.ui.elements.Button.clickButton
import org.openqa.selenium.By
import java.time.Duration
import java.util.*

class BorrowersPage {

  private  val searchButton : By = By.xpath("//button[@ng-disabled='disableSearchBtn']")
  private  val borrowerId : By = By.xpath("//*[@id='main']/div/table/tbody/tr/td/a")

  fun clickSearchButton(){
    clickButton(searchButton)
  }

  fun getBorrowerId(): String? {
    return `$`(borrowerId).text
    }
  }
