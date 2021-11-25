package task_1064.core.application.elements

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

object Button {

  fun clickButton(element: SelenideElement){
    element
      .shouldBe(Condition.visible)
      .click()
  }
}