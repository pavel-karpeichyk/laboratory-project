package core.ui.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import org.openqa.selenium.By

abstract class BasePage {
  protected abstract val url: String


  fun openPage() {
    open(url)
  }

  fun getPageUrl(): String {
    return url
  }

 abstract fun verifyPageOpened()
}