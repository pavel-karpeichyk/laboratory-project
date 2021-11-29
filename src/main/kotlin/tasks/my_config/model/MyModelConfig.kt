package tasks.my_config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MyModelConfig (
  @JsonProperty("host") val myHost: String?=null,
  val url: String? = null,
  var login: String? = null,
  var password: String? = null
)