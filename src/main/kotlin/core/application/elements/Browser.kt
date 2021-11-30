package core.application.elements

import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Browser {

  private val logger: Logger = LogManager.getLogger()

  fun verifyCurrentUrl(url: String): String {
    logger.info("Verify Current Url - $url")
    return webdriver().shouldHave(url(url)).toString()
  }
}