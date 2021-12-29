package core.context.constant

import core.context.TafContext

data class AppConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationApiEndpoint: String,
  val registrationUiEndpoint: String,
  val crmLoginEndpoint: String,
  var cmrUserConfig: CrmUserConfig
) : TafContext {
  companion object {
    private const val PROTOCOL_HTTPS = "https://"
  }

  fun getBaseUrl() = "$PROTOCOL_HTTPS$host"
  fun getBaseUrlWithAuth() = "$PROTOCOL_HTTPS$user:$pass@$host"
  fun getUrlWithBasicAuthSelectedEndpoint(endpoint: String) = "${getBaseUrlWithAuth()}$endpoint"
}
