package core.personal_user_data

data class PersonalUserDataConfig(
  var name: String,
  var surname: String,
  var email: String,
  var passportIdentificationNumber: String,
  var dateOfBirth: String
)
