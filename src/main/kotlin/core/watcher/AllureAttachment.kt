package core.watcher

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.apache.commons.io.FileUtils
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.OutputType
import java.io.File

open class AllureAttachment {

  private val logger: Logger = LogManager.getLogger()

  private fun createScreenshot(): File? {
    return Selenide.screenshot(OutputType.FILE)
  }

  @Attachment()
  fun saveScreenshot() {
    if (hasWebDriverStarted()) {
      Allure.addAttachment("Screenshot", FileUtils.openInputStream(createScreenshot()))
      logger.info("Screenshot attachments")
    } else
      logger.info("Screenshot doesn't attachment because web driver doesn't set up")
  }
}