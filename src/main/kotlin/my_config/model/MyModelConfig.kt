package my_config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import my_config.factory.ContentYAML

@JsonIgnoreProperties(ignoreUnknown = true)
 data class MyModelConfig (
  @JsonProperty("host") val myHost: String?=null,
  val url: String? = null,
  var login: String? = null,
  var password: String? = null
)
{
  fun getValue(key: String, content: MyModelConfig): String {
    var value: String?=null
    when(key){
      "url" -> value = content.url
      "login" -> value = MyModelConfig().url
      "host" -> value = MyModelConfig().url
    }
    return  value!!
  }
}


