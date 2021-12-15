package steps

import core.holder.StaticContextHolder.getConfig

class RegistrationPageSteps {

  private val registrationUrl: String = getConfig().run { getUrlWithBasicAuthSelectedEndpoint(registrationApiEndpoint) }

  fun getPageUrl(): String {
    return registrationUrl
  }
}