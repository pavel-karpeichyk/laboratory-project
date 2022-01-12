package core.mock.controller

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import core.mock.config.MockConfig

interface MockController {

 fun  setUpStub(mockConfig: MockConfig): StubMapping?
 fun removeStub()
}