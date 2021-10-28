package my_config.factory

import my_config.model.MyModelConfig

interface ContentFactory {

  fun getContent(filePath: String): MyModelConfig
}