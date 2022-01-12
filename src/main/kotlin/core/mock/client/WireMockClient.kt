package core.mock.client

import com.github.tomakehurst.wiremock.client.WireMock
import core.context.staticContext

class WireMockClient : TafMockClient {

  private lateinit var wireMockClient: WireMock

  override fun getClient(): WireMock {
    return WireMock(staticContext.wireMockClientConfig.host, staticContext.wireMockClientConfig.port).also {
      wireMockClient = it
    }
  }
}