package steps

import core.application.app_config.model.AppConfig
import core.holder.static_context_holder.StaticContextHolder.getContext

class RegistrationPageSteps {

private val registrationUrl: String = getContext<AppConfig>().run { getUrlWithBasicAuthSelectedEndpoint(registrationApiEndpoint) }

  fun getPageUrl(): String {
    return registrationUrl
  }
}