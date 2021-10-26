package my_config.factory

import my_config.model.MyModelConfiguration

interface ContentFactory {

  fun getContent(filePath: String): MyModelConfiguration
}