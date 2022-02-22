package core.ui.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Hyperlink {

  private val logger: Logger = LogManager.getLogger()

  fun getValueHyperlink(locator: SelenideElement): String {
    val value: String = `$`(locator).shouldBe(Condition.visible).text
    logger.info("Get $value from borrowers id table ")
    return value
  }
}