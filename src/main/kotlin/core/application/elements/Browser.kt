package core.application.elements

import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url

object Browser {

  fun verifyCurrentUrl(url: String): String {
    return webdriver().shouldHave(url(url)).toString()
  }
}