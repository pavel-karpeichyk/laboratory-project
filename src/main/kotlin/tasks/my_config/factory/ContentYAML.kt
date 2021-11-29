package tasks.my_config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import tasks.my_config.model.MyModelConfig
import tasks.my_config.provider.FileType
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

class ContentYAML() : ContentFactory {
   private val log: Logger = LogManager.getLogger("YAML")
  override fun getContent(filePath: String): MyModelConfig {
    log.info("Start YAML Factory")
    return ObjectMapper(YAMLFactory()).registerModule(KotlinModule()).readValue<MyModelConfig>(File("${filePath}${FileType.YAML.fileExtension}"))
  }
}