package core.holder

import core.application.app_config.model.AppConfig

interface ContextHolder {

  fun clearContext()
  fun getConfig(): Any

}