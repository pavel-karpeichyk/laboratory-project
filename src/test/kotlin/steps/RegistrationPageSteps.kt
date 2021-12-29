package steps

import core.holder.staticContext

class RegistrationPageSteps {

  private val registrationUrl: String =
    staticContext.run { getUrlWithBasicAuthSelectedEndpoint(registrationApiEndpoint) }

  fun getPageUrl(): String {
    return registrationUrl
  }
}