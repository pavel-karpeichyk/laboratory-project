package core.mock.controller

import com.github.tomakehurst.wiremock.admin.model.SingleStubMappingResult
import core.mock.config.MockConfig

interface MockController {

  fun setUpStub(mockConfig: MockConfig): SingleStubMappingResult
  fun removeStub(mockConfig: MockConfig)
}