package my_config.provider

import my_config.factory.ContentFactory
import my_config.factory.ContentJSON
import my_config.factory.ContentYAML
import my_config.model.MyModelConfig

class MyConfigProvider() {

  companion object {

    private const val CONFIG_FILE_PATH = "./src/test/resources/my_config/myConfig"

     fun getContentFromFile(fileType: FileType): MyModelConfig {
     val contentFactory: ContentFactory= when (fileType) {
        FileType.YAML ->  ContentYAML()
        FileType.JSON ->  ContentJSON()
      }
       return contentFactory.getContent(CONFIG_FILE_PATH)
    }
  }
}