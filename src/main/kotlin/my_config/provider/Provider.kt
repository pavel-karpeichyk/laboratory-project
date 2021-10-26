package my_config.provider

import my_config.factory.ContentJSON
import my_config.factory.ContentYAML
import my_config.model.MyModelConfiguration

class Provider() {

  companion object {

    val configFilePath = "./src/test/resources/my_config/myConfig"

    open fun getContentFromFile(file: FileType): MyModelConfiguration {

     return when (file) {
        FileType.YAML ->  ContentYAML().getContent(configFilePath)
        FileType.JSON ->  ContentJSON().getContent(configFilePath)
      }
    }
  }
}