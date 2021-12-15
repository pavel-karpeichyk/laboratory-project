package core.application.pages

import core.holder.StaticContextHolder.getConfig

class RegistrationPage : BasePage() {

  override val url: String = getConfig().run { getUrlWithBasicAuthSelectedEndpoint(registrationUiEndpoint) }

  fun getPageUrl(): String {
    return url
  }
}