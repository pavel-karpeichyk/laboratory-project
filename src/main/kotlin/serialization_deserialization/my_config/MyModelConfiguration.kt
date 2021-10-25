package serialization_deserialization.my_config

import kotlinx.serialization.Serializable

@Serializable
data class MyModelConfiguration(var url: String="default", var login: String="default", var password: String="default"){

}
