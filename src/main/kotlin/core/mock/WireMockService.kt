package core.mock

import com.github.tomakehurst.wiremock.admin.model.SingleStubMappingResult
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.context.staticContext
import core.mock.config.MockConfig
import core.mock.config.WireMockMappingBuilder

class WireMockService {

  private var wireMockConfigBuilder: WireMockMappingBuilder = WireMockMappingBuilder()
  private var client: WireMock =
    WireMock(staticContext.wireMockClientConfig.host, staticContext.wireMockClientConfig.port)

  fun raiseStub(mockConfig: MockConfig): SingleStubMappingResult {
    mockConfig.mappingBuilder = wireMockConfigBuilder.getStubMapping(mockConfig)
    val stub: StubMapping = stubFor(
      (mockConfig.mappingBuilder)
    )
    mockConfig.id = stub.id
    return client.getStubMapping(mockConfig.id) ?: throw IllegalArgumentException("Stub doesn't raise")
  }

  fun deleteStub(mockConfig: MockConfig) {
    client.getStubMapping(mockConfig.id)
  }
}