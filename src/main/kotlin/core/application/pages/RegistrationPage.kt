package core.application.pages

import core.application.app_config.model.AppConfig
import core.holder.static_context_holder.StaticContextHolder.getContext

class RegistrationPage : BasePage() {

  override val url: String = getContext<AppConfig>().run { getUrlWithBasicAuthSelectedEndpoint(registrationUiEndpoint) }

  fun getPageUrl(): String {
    return url
  }
}