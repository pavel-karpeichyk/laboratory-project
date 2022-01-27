package core.watcher

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner.getWebDriver
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import java.io.File

open class AllureAttachment {

  private fun createScreenshot(): File? {
    return if (getWebDriver() != null) {
      Selenide.screenshot(OutputType.FILE)
    } else
      throw IllegalArgumentException("Web Driver doesn't set up")
  }

  @Attachment()
  fun saveScreenshot() {
    Allure.addAttachment("Screenshot", FileUtils.openInputStream(createScreenshot()))
  }
}