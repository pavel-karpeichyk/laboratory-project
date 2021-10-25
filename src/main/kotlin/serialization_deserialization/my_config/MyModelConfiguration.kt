package serialization_deserialization.my_config

import kotlinx.serialization.Serializable

@Serializable
data class MyModelConfiguration(var url: String, var login: String, var password: String){

}
