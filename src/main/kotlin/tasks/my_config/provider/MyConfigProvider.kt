package tasks.my_config.provider

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import tasks.my_config.factory.ContentFactory
import tasks.my_config.factory.ContentJSON
import tasks.my_config.factory.ContentYAML
import tasks.my_config.model.MyModelConfig

class MyConfigProvider {

  companion object {
    private val logger: Logger = LogManager.getLogger("Config")
    private const val CONFIG_FILE_PATH = "./src/test/resources/tasks.my_config/myConfig"

    fun getContentFromFile(fileType: FileType): MyModelConfig {
      logger.info("Select factory to get config from file")
      val contentFactory: ContentFactory = when (fileType) {
        FileType.YAML -> ContentYAML()
        FileType.JSON -> ContentJSON()
      }
      logger.info("Get file.$fileType")
      return contentFactory.getContent(CONFIG_FILE_PATH)
    }
  }
}