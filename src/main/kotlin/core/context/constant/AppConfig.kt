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
  var protocol: String
) : TafContext {

  fun getBaseUrl() = "$protocol$host"
  fun getBaseUrlWithAuth() = "$protocol$user:$pass@$host"
  fun getUrlWithBasicAuthSelectedEndpoint(endpoint: String) = "${getBaseUrlWithAuth()}$endpoint"
}
