package serialization_deserialization.provider

import serialization_deserialization.my_config.MyModelConfiguration

interface ContentFactory {
  fun getContent(): MyModelConfiguration
}