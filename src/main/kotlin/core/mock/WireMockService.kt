package core.mock

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.mock.client.WireMockClient
import core.mock.config.MockConfig
import core.mock.config.WireMockConfigBuilder

class WireMockService {

  private var wireMockConfigBuilder: WireMockConfigBuilder = WireMockConfigBuilder()
  private var client: WireMock = WireMockClient().getClient()

  fun getStub(mockConfig: MockConfig): StubMapping {
    mockConfig.mappingBuilder = wireMockConfigBuilder.getStubConfig(mockConfig)
    var customStub: StubMapping? = null
    val stub: StubMapping = stubFor(
      (mockConfig.mappingBuilder)
    )
    if (verifyStub(stub, mockConfig)) {
      customStub = stub
    }
    return customStub ?: throw IllegalArgumentException("Stub doesn't setup")
  }

  private fun verifyStub(stub: StubMapping?, mockConfig: MockConfig): Boolean {
    mockConfig.id = stub?.id
    return client.allStubMappings().mappings.map { it.id }.contains(mockConfig.id)
  }

  fun deleteStub() {
    client.removeMappings()
  }
}