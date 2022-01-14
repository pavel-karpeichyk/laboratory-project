package core.mock.controller

import core.mock.WireMockService
import core.mock.config.MockConfig

class WireMockController(private val wireMockService: WireMockService = WireMockService()) : MockController {

  override fun setUpStub(mockConfig: MockConfig) = wireMockService.raiseStub(mockConfig)
  override fun removeStub(mockConfig: MockConfig) = wireMockService.deleteStub(mockConfig)
}