package task_1064.core.application.pages

import com.codeborne.selenide.Selenide.open

abstract  class BasePage {

  open fun openPage() {
    open()
  }
}