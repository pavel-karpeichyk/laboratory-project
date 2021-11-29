package core.application.pages

import com.codeborne.selenide.Selenide.open

class RegistrationPage : BasePage() {

  override val url: String = "es-alpha.moneyman.ru/client-area/#/registration?"

  override fun openPage() : RegistrationPage {
    open(url)
    return  this
  }

  @JvmName("getUrlRegistrationPage")
   fun getUrl(): String {
    return url
  }
}