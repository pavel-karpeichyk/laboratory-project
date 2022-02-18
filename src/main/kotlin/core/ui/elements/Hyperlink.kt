package core.ui.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import java.time.Duration

object Hyperlink {
  private val logger: Logger = LogManager.getLogger()

  fun clickHyperlink(locator: By) {
    Selenide.`$`(locator).also { element ->
      logger.info("Click hyperlink: ${element.text()}")
      element.shouldBe(Condition.visible, Duration.ofSeconds(20)).click()
    }
  }
}