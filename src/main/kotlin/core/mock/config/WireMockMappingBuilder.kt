package core.mock.config

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock

class WireMockMappingBuilder {

  private fun getStubResponseConfig(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    with(mockConfig) {
      val responseDefinitionBuilder = WireMock.aResponse()
      responseDefinitionBuilder.withStatus(status!!)
        .withBody(body)
      header.forEach {
        responseDefinitionBuilder.withHeader(it.key, it.value)
      }
      return responseDefinitionBuilder
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