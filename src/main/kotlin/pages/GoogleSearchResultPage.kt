package pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class GoogleSearchResultPage {

  fun `verify search result`(searchText: String){

    `$`(By.xpath("//h3")).shouldHave(Condition.text(searchText))
  }
}