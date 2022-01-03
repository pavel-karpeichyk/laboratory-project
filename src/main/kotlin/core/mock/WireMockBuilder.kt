package core.mock

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import core.mock.client.TafMockClient

class WireMockBuilder : TafMockClient {

  override fun requestStub() {
    TODO("Not yet implemented")
  }

  override fun responseStub(): ResponseDefinitionBuilder? {
    return ResponseDefinitionBuilder().withHeader("Set_Cookie", Cookie().cookieAuthUser()).withStatus(200)
      .withBody(getResponseBodyToString())
  }

  fun getResponseBodyToString(): String?{
    return  Thread.currentThread().contextClassLoader.getResourceAsStream("src/main/resources/response.json")?.readBytes() ?.toString(Charsets.UTF_8)
  }

  override fun getClient() {
  }
}