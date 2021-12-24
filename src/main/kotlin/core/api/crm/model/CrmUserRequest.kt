package core.api.crm.model

data class CrmUserRequest(
  var login: String,
  var password: String,
  var captcha: String
)