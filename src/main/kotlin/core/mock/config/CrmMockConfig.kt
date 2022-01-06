package core.mock.config

import java.util.*

object CrmMockConfig : MockConfig {
  override var id: UUID? = null
  override val priority: Int = 1
  override val mockName: String = "My_Stub"
}