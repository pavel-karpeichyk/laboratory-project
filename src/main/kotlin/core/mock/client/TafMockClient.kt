package core.mock.client

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.http.ResponseDefinition

interface TafMockClient {
fun requestStub(): MappingBuilder?
  fun responseStub(): ResponseDefinitionBuilder?
  fun getClient(): WireMock
}