package task_1064.core.application.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.Keys

object Input {

  fun setValue(element: SelenideElement, value: String) {
    element
      .shouldBe(Condition.visible)
      .sendKeys(Keys.CONTROL, "A")
    element.sendKeys(value)
  }
}