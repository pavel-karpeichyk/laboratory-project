package core.ui.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object Input {

  private val logger: Logger = LogManager.getLogger()

  fun setInputWithConditionPresenceValue(locator: By, value: String) {
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible).sendKeys(Keys.CONTROL, "A")
      logger.info("Set $value in input element")
      element.sendKeys(value)
      element.shouldHave(Condition.value(value))
    }
  }

  fun setInputValue(locator: By, value: String) {
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible)
      logger.info("Set $value in input element")
      element.sendKeys(value)
    }
  }

  fun getInputValue(locator: By): String? {
    var value: String? = ""
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible)
      value = element.value
      logger.info("Get $value from input element")//nonstable work
    }
    return value
  }
}