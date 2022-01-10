package core.mock

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.post
import core.context.staticContext
import core.mock.client.TafMockClient
import core.mock.config.MockConfig

class WireMockBuilder : TafMockClient {

  private lateinit var wireMockClient: WireMock

  fun responseStub(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return with(mockConfig) {
      ResponseDefinitionBuilder()
        .withHeader(header.keys.elementAt(0), header["Set-Cookie"])
        .withStatus(status!!)
        .withBody(body)
    }
  }

  override fun getClient(): WireMock {
    return WireMock(staticContext.wireMockClientConfig.localHost, staticContext.wireMockClientConfig.port).also {
      wireMockClient = it
    }
  }

  override fun getMappingStub(mockConfig: MockConfig): MappingBuilder? =
    with(mockConfig) {
      post(WireMock.urlEqualTo(staticContext.crmLoginEndpoint))
        .atPriority(priority)
        .withName(mockName)
        ?.willReturn(
          WireMockBuilder().responseStub(mockConfig)
        )
    }
}