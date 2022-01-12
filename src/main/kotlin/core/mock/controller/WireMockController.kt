package core.mock.controller

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.mock.WireMockService
import core.mock.config.MockConfig

class WireMockController : MockController {

  private val wireMockService: WireMockService = WireMockService()

  override fun setUpStub(mockConfig: MockConfig): StubMapping? = wireMockService.getStub(mockConfig)
  override fun removeStub() = wireMockService.deleteStub()
}