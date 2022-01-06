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

  override fun requestStub(): MappingBuilder? {
    return with(CrmMockConfig) {
      post(WireMock.urlEqualTo(staticContext.crmLoginEndpoint))
        .atPriority(priority)
        .withName(mockName)
    }
  }

  fun responseStub(): ResponseDefinitionBuilder? {
    return ResponseDefinitionBuilder()
      .withHeader("Set-Cookie", Cookie().cookieAuthUser())
      .withStatus(200)
      .withBody(Convertor().getResponseBodyToString())
  }

  override fun getClient(): WireMock {
    return WireMock(staticContext.localhost, staticContext.port).also { wireMockClient = it }
  }

  fun getMappingStub(): MappingBuilder? =
    WireMockBuilder().requestStub()
      ?.willReturn(
        WireMockBuilder().responseStub()
      )
}