package task_1064.core.application.pages

import com.codeborne.selenide.Selenide.open

class RegistrationPage : BasePage() {

  private val url: String = "es-alpha.moneyman.ru/client-area/#/registration?"

  override fun openPage() {
    open()
  }

  fun getUrl(): String {
    return url
  }
}