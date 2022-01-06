package core.mock.client

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock

interface TafMockClient {
  fun requestStub(): MappingBuilder?
  fun getClient(): WireMock
}