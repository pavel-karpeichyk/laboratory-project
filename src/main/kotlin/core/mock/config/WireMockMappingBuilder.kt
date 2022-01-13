package core.mock.config

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock

class WireMockMappingBuilder {

  private fun getStubResponseConfig(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return with(mockConfig) {
      ResponseDefinitionBuilder()
        .withHeader(header.keys.elementAt(0), header["Set-Cookie"])
        .withStatus(status!!)
        .withBody(body)
    }
  }

  fun getStubMapping(mockConfig: MockConfig): MappingBuilder? =
    with(mockConfig) {
      WireMock.any(WireMock.urlEqualTo(mockConfigUrl))
        .atPriority(priority)
        .withName(mockName)
        ?.willReturn(
          WireMockMappingBuilder().getStubResponseConfig(mockConfig)
        )
    }
}