package core.personal_user_data

data class PersonalUserDataConfig(
  var name: String? = null,
  var surname: String? = null,
  var email: String? = null,
  var passportIdentificationNumber: String? = null,
  var dateOfBirth: String? = null
)
