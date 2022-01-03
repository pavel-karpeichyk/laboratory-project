package core.mock.client

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.http.ResponseDefinition

interface TafMockClient {
fun requestStub()
fun responseStub(): ResponseDefinitionBuilder?
  fun getClient()
}