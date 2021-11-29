package core.application.pages

class RegistrationPage : BasePage() {

  override val url: String = "es-alpha.moneyman.ru/client-area/#/registration?"

  fun getPageUrl(): String {
    return url
  }
}