package core.mock

import com.github.tomakehurst.wiremock.client.WireMock
import core.context.wireMockClientConfig
import core.mock.config.MockConfig
import core.mock.config.WireMockMappingBuilder

class WireMockService {

  private val wireMockConfigBuilder: WireMockMappingBuilder = WireMockMappingBuilder()
  private val client: WireMock = WireMock(
    wireMockClientConfig.host,
    wireMockClientConfig.port
  )

  fun raiseStub(mockConfig: MockConfig) {
    mockConfig.mappingBuilder = wireMockConfigBuilder.getStubMapping(mockConfig)
    client.register(mockConfig.mappingBuilder).apply { mockConfig.id = this.id }
    verifyStub(mockConfig)
  }

  private fun verifyStub(mockConfig: MockConfig) {
    client.getStubMapping(mockConfig.id) ?: throw IllegalArgumentException("Stub doesn't raise")
  }

  fun deleteStub(mockConfig: MockConfig) {
    client.removeStubMapping(mockConfig.mappingBuilder)
  }
}