package core.personal_user_data

import java.sql.Date

data class PersonalUserDataConfig(
  val name: String,
  val surname: String,
  val email: String,
  val passportIdentificationNumber: String,
  val dateOfBirth: Date// тонкое место может не совпадать форматы дат
)
