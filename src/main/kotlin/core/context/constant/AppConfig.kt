package core.context.constant

import core.context.TafContext

data class AppConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationApiEndpoint: String,
  val registrationUiEndpoint: String,
  val crmLoginEndpoint: String,
  var cmrUserConfig: CrmUserConfig,
  var wireMockClientConfig: WireMockClientConfig
) : TafContext {
  companion object {
    private const val PROTOCOL_HTTPS = "https://"
    private const val PROTOCOL_HTTP = "http://"
  }

  fun getBaseUrl() = "$PROTOCOL_HTTPS$host"
  fun getLocalhostUrl() = "$PROTOCOL_HTTP${wireMockClientConfig.localhost}:${wireMockClientConfig.port}"
  fun getBaseUrlWithAuth() = "$PROTOCOL_HTTPS$user:$pass@$host"
  fun getUrlWithBasicAuthSelectedEndpoint(endpoint: String) = "${getBaseUrlWithAuth()}$endpoint"
}
