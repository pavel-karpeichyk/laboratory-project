package tasks.my_config.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import tasks.my_config.model.MyModelConfig
import tasks.my_config.provider.FileType
import java.io.File

class ContentJSON : ContentFactory {
  private val logger: Logger = LogManager.getLogger("JSON")
  override fun getContent(filePath: String): MyModelConfig {
    logger.info("Start JSON factory")
    return jacksonObjectMapper().readValue<MyModelConfig>(File("${filePath}${FileType.JSON.fileExtension}"))
  }
}