package core.personal_user_data

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.sql.Date

data class PersonalUserDataConfig(
  @JsonProperty("first_name") var name: String? = null,
  @JsonProperty("first_last_name") var surname: String? = null,
  var email: String? = null,
  @JsonProperty("DNI") var passportIdentificationNumber: String? = null,
  @JsonProperty("birthday")

  var dateOfBirth: String? = null,
  @JsonIgnore val smsCode: String = "1111"
)
