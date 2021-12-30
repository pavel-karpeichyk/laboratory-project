package core.ui.pages

import core.context.staticContext

class RegistrationPage : BasePage() {

  override val url: String =
    staticContext.run { getUrlWithBasicAuthSelectedEndpoint(registrationUiEndpoint) }

  fun getPageUrl(): String {
    return url
  }
}