package core.mock.config

import com.github.tomakehurst.wiremock.client.MappingBuilder
import core.context.crmUserConfig
import core.convecters.FileConverter
import java.util.*

data class CrmMockConfig(
  override var id: UUID? = null,
  override val priority: Int = 1,
  override val mockName: String = "My_Stub",
  override val header: Map<String, String> = mapOf("Set-Cookie" to "AuthUser=fakeAuthToken"),
  override val status: Int = 200,
  override val responseFilePath: String = "CrmSuccessLoginResponse.json",
  override var body: String? = null,
  override var mappingBuilder: MappingBuilder?= null
) : MockConfig {

  init {
    if (null == body) {
      body = FileConverter().getResponseBodyAsString(responseFilePath)
    }
  }
}