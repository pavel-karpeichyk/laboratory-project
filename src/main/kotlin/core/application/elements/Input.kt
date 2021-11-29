package core.application.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object Input {

  private val logger: Logger = LogManager.getLogger()

  fun setInputValue(locator: By, value: String) {
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible).sendKeys(Keys.CONTROL, "A")
      element.sendKeys(value)
      logger.info("Set $value in input element")
    }
  }
}