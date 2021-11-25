package task_1064.core.application.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.Keys

object Input {

  private  val logger: Logger = LogManager.getLogger()

  fun setInputValue(element: SelenideElement, value: String) {
    element.shouldBe(Condition.visible).sendKeys(Keys.CONTROL, "A")
    element.sendKeys(value)
    logger.info("Set $value in input element")
  }
}