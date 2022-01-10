package core.mock

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.post
import core.context.staticContext
import core.mock.client.TafMockClient
import core.mock.config.CrmMockConfig

class WireMockBuilder : TafMockClient {

  private lateinit var wireMockClient: WireMock

  fun responseStub(): ResponseDefinitionBuilder? {
    return with(CrmMockConfig) {
      ResponseDefinitionBuilder()
        .withHeader(header.keys.elementAt(0), header["Set-Cookie"])
        .withStatus(status)
        .withBody(body)
    }
  }

  override fun getClient(): WireMock {
    return WireMock(staticContext.wireMockClientConfig.localhost, staticContext.wireMockClientConfig.port).also {
      wireMockClient = it
    }
  }

  override fun getMappingStub(): MappingBuilder? =
    with(CrmMockConfig) {
      post(WireMock.urlEqualTo(staticContext.crmLoginEndpoint))
        .atPriority(priority)
        .withName(mockName)
        ?.willReturn(
          WireMockBuilder().responseStub()
        )
    }
}