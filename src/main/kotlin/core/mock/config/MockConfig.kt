package core.mock.config

import java.util.*

interface MockConfig {
  var id: UUID?
  val priority: Int?
  val mockName: String?
  val header: Map<String, String>
  val status: Int?
  val body: String?
}