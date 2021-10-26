package my_config.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import my_config.model.MyModelConfiguration
import my_config.provider.FileType
import java.io.File

class ContentJSON() : ContentFactory {

  override fun getContent(filePath: String): MyModelConfiguration {
    return jacksonObjectMapper().readValue<MyModelConfiguration>(File("${filePath}${FileType.JSON.fileExtension}"))
  }
}