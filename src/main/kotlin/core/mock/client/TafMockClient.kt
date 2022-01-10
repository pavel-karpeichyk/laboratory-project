package core.mock.client

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import core.mock.config.MockConfig

interface TafMockClient {
  fun getMappingStub(mockConfig: MockConfig): MappingBuilder?
  fun getClient(): WireMock
}