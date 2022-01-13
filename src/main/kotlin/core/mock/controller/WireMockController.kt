package core.mock.controller

import com.github.tomakehurst.wiremock.admin.model.SingleStubMappingResult
import core.mock.WireMockService
import core.mock.config.MockConfig

class WireMockController : MockController {

  private val wireMockService: WireMockService = WireMockService()

  override fun setUpStub(mockConfig: MockConfig): SingleStubMappingResult = wireMockService.raiseStub(mockConfig)
  override fun removeStub(mockConfig: MockConfig) = wireMockService.deleteStub(mockConfig)
}