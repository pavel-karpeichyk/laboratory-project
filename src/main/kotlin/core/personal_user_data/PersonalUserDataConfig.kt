package core.personal_user_data

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

data class PersonalUserDataConfig(
  @JsonProperty("first_name")
  var name: String? = null,
  @JsonProperty("first_last_name")
  var surname: String? = null,
  var email: String? = null,
  @JsonProperty("DNI")
  var passportIdentificationNumber: String? = null,
  @JsonProperty("birthday")
  var dateOfBirth: String? = null,
  @JsonIgnore
  val smsCode: String = "1111"
)
