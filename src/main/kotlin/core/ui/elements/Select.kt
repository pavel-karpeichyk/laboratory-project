package core.ui.elements

import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object Select {

  private val logger: Logger = LogManager.getLogger()

  fun getSelectValue(locator: By): String {
    var value: String = `$`(locator).text
    logger.info("Get $value from select  element")
    return value
  }
}