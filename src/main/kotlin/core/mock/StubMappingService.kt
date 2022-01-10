package core.mock

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.mock.config.CrmMockConfig
import core.mock.config.MockConfig

class StubMappingService {

  private var wireMockBuilder: WireMockBuilder = WireMockBuilder()
  private var client: WireMock = wireMockBuilder.getClient()

  fun getStub(mockConfig: MockConfig): StubMapping {
    var customStub: StubMapping? = null
    val stub: StubMapping = client.register(wireMockBuilder.getMappingStub())
    if (verifyStub(stub)) {
      customStub = stub
    }
    return customStub ?: throw IllegalArgumentException("Stub doesn't setup")
  }

  private fun verifyStub(stub: StubMapping?): Boolean {
    CrmMockConfig.id = stub?.id
    return client.allStubMappings().mappings.map { it.id }.contains(CrmMockConfig.id)
  }

  fun removeStubs() {
    client.removeMappings()
  }
}