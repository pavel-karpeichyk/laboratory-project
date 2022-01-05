package core.mock

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.post
import core.mock.client.TafMockClient

class WireMockBuilder : TafMockClient {

  private val host: String = "localhost"
  private val port: Int = 8080
  private val wireMockClient: WireMock = WireMock(host, port)

  override fun requestStub(): MappingBuilder? {
    return post(WireMock.urlEqualTo("/secure/rest/sign/in"))
      .atPriority(1)
      .withName("Pavel")
  }

  override fun responseStub(): ResponseDefinitionBuilder? {
    return ResponseDefinitionBuilder()
      .withHeader("Set-Cookie", Cookie().cookieAuthUser())
      .withStatus(200)
      .withBody(getResponseBodyToString())
  }

  override fun getClient(): WireMock {
    return wireMockClient
  }

  fun getMappingStub(): MappingBuilder? =
    WireMockBuilder().requestStub()
      ?.willReturn(
        WireMockBuilder().responseStub()
      )

  private fun getResponseBodyToString(): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream("response.json")
      ?.readBytes()?.toString(Charsets.UTF_8)
  }
}