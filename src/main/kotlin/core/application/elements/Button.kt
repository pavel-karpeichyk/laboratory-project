package core.application.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object Button {

  private val logger: Logger = LogManager.getLogger()

  fun clickButton(locator: By) {
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible).click()
      logger.info("Click button: ${element.text()}")
    }
  }
}