package core.mock.config

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import core.context.staticContext

class WireMockConfigBuilder {

  private fun responseStubConfig(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return with(mockConfig) {
      ResponseDefinitionBuilder()
        .withHeader(header.keys.elementAt(0), header["Set-Cookie"])
        .withStatus(status!!)
        .withBody(body)
    }
  }

  fun getStubConfig(mockConfig: MockConfig): MappingBuilder? =
    with(mockConfig) {
      WireMock.post(WireMock.urlEqualTo(staticContext.crmLoginEndpoint))
        .atPriority(priority)
        .withName(mockName)
        ?.willReturn(
          WireMockConfigBuilder().responseStubConfig(mockConfig)
        )
    }
}