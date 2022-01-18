package core.mock.controller

import core.mock.config.MockConfig

interface MockController {

  fun setUpStub(mockConfig: MockConfig)
  fun removeStub(mockConfig: MockConfig)
}