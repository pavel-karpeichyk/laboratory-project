package core.ui.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.`$`
import okhttp3.internal.wait
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import java.time.Duration

object Button {

  private val logger: Logger = LogManager.getLogger()

  fun clickButton(locator: By){
    `$`(locator).also { element ->
      logger.info("Click button: ${element.text()}")
      element.shouldBe(Condition.visible, Duration.ofSeconds(30)).click()
    }
  }
}