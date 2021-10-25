package serialization_deserialization.provider

import java.lang.ref.Reference

enum class FileType(val path: String) {
  JSON("./src/test/resources/my_config/myConfig.json") ,
  YAML("./src/test/resources/my_config/myConfig.yaml")
}