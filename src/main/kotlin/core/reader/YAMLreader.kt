package core.reader

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File

object YAMLreader {

  fun <T> readConfig(filePath: String, entity: Class<T>): T {
    return ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
      .readValue(File(filePath), entity)
  }
}