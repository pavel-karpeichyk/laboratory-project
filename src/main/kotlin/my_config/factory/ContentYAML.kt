package my_config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import my_config.model.MyModelConfig
import my_config.provider.FileType
import java.io.File

class ContentYAML() : ContentFactory {

  override fun getContent(filePath: String): MyModelConfig {
    return ObjectMapper(YAMLFactory()).registerModule(KotlinModule()).readValue<MyModelConfig>(File("${filePath}${FileType.YAML.fileExtension}"))
  }
}