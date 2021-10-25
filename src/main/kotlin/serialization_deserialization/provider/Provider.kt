package serialization_deserialization.provider

import serialization_deserialization.my_config.MyModelConfiguration

open class Provider() {

  companion object {

    open fun getContentFromFile(file: FileType): MyModelConfiguration {
      var content: MyModelConfiguration
      when (file) {
        FileType.YAML -> content = ContentYAML().getContent()
        FileType.JSON -> content = ContentJSON().getContent()
      }
      return content
    }
  }
}