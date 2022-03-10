package core.context.constant

import core.context.TafContext

data class AppConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationApiEndpoint: String,
  val registrationUiEndpoint: String,
  val crmLoginApiEndpoint: String,
  var cmrUserConfig: CrmUserConfig,
  var wireMockClientConfig: WireMockClientConfig,
  var databaseClientConfig: DatabaseClientConfig
) : TafContext {
  companion object {
    private const val PROTOCOL_HTTPS = "https://"
    private const val PROTOCOL_HTTP = "http://"
  }

  fun getBaseUrl() = "$PROTOCOL_HTTPS$host"
  fun getWireMockUrl() = "$PROTOCOL_HTTP${wireMockClientConfig.host}:${wireMockClientConfig.port}"
  fun getBaseUrlWithAuth() = "$PROTOCOL_HTTPS$user:$pass@$host"
  fun getUrlWithBasicAuthSelectedEndpoint(endpoint: String) = "${getBaseUrlWithAuth()}$endpoint"
}
