package core.application.pages

import com.codeborne.selenide.Selenide.open

abstract  class BasePage {
  protected abstract val  url: String

  open fun openPage(): BasePage{
    open(url)
    return this
  }
}