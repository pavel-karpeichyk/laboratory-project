package core.application.pages

import core.holder.staticContext

class RegistrationPage : BasePage() {

  override val url: String =
    staticContext.run { getUrlWithBasicAuthSelectedEndpoint(registrationUiEndpoint) }

  fun getPageUrl(): String {
    return url
  }
}