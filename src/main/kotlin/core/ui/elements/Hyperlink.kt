package core.ui.elements

import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Hyperlink {

  private val logger: Logger = LogManager.getLogger()

  fun getHyperlinkValue(element: SelenideElement): String {
    val value: String = element.text
    logger.info("Get $value from $element")
    return value
  }
}