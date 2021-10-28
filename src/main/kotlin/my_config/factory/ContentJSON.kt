package my_config.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import my_config.model.MyModelConfig
import my_config.provider.FileType
import java.io.File

class ContentJSON() : ContentFactory {

  override fun getContent(filePath: String): MyModelConfig {
    return jacksonObjectMapper().readValue<MyModelConfig>(File("${filePath}${FileType.JSON.fileExtension}"))
  }
}