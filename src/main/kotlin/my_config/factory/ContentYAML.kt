package my_config.factory

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.readValue
import my_config.model.MyModelConfiguration
import my_config.provider.FileType
import java.io.File

class ContentYAML() : ContentFactory {

  override fun getContent(filePath: String): MyModelConfiguration {
    return YAMLMapper().readValue<MyModelConfiguration>(File("${filePath}${FileType.YAML.fileExtension}"))
  }
}