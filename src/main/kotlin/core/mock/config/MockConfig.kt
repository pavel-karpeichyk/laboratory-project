package core.mock.config

import com.github.tomakehurst.wiremock.client.MappingBuilder
import java.util.*

interface MockConfig {
  var id: UUID?
  val priority: Int?
  val mockName: String?
  val header: Map<String, String>
  val status: Int?
  val responseFilePath: String?
  val body: String?
  var mappingBuilder: MappingBuilder?
}