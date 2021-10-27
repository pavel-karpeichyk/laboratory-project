package my_config.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("ignoreUnknownInFile")
data class MyModelConfig (
  @get:JsonProperty("host") val myHost: String?=null,
  val url: String? = null,
  var login: String? = null,
  var password: String? = null,
    @JsonIgnore val ignoreNullableInModel: String? = "NOT_DEFINED"
)