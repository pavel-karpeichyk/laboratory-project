package core.mock

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.mock.config.CrmMockConfig

class Service {

  private var wireMockBuilder: WireMockBuilder = WireMockBuilder()
  private var client: WireMock = wireMockBuilder.getClient()

  fun getStub(): StubMapping {
    var customStub: StubMapping? = null
    val stub: StubMapping = client.register(wireMockBuilder.getMappingStub())
    CrmMockConfig.id = stub.id
    val listStubs: List<StubMapping> = client.allStubMappings().mappings
    for (stub in listStubs) {
      if (stub.id == CrmMockConfig.id) {
        customStub = stub
      }
    }
    return customStub ?: throw IllegalArgumentException("Stub doesn't setup")
  }

  fun removeStubs() {
    client.removeMappings()
  }
}