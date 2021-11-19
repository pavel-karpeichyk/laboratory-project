package pages

import com.codeborne.selenide.Selenide
import org.openqa.selenium.By

class GoogleSearchPage() {

  fun `search`(searchText: String){
    Selenide.`$`(By.name("q")).sendKeys(searchText)
    Selenide.`$`(By.name("q")).submit()

  }
}