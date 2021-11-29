package tasks.my_config.factory

import tasks.my_config.model.MyModelConfig

interface ContentFactory {

  fun getContent(filePath: String): MyModelConfig
}