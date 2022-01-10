package core.mock.config

import core.convecters.FileConverter
import java.util.*

object CrmMockConfig : MockConfig {
  override var id: UUID? = null
  override val priority: Int = 1
  override val mockName: String = "My_Stub"
  override val header: Map<String, String> = WireMockHeader().getHeaderWithAuthToken()
  override val status: Int = 200
  override val body: String? = FileConverter().getResponseBodyToString("CrmSuccessLoginResponse.json")
}