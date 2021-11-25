package task_1064.core.application.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Button {

  private  val logger: Logger = LogManager.getLogger()

  fun clickButton(element: SelenideElement){
    element.shouldBe(Condition.visible).click()
    logger.info("Click button: ${element.text()}")
  }
}