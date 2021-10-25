package serialization_deserialization.provider

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import serialization_deserialization.my_config.MyModelConfiguration
import java.io.File

class ContentJSON(): ContentFactory {
    override fun getContent(): MyModelConfiguration {
      return jacksonObjectMapper().readValue<MyModelConfiguration>(File(FileType.JSON.path))
    }


}