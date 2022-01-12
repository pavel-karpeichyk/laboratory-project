package core.api.crm

import core.api.crm.model.CrmUserRequest
import core.context.crmUserConfig

class CrmRequestBuilder {

  fun getAuthRequest(): CrmUserRequest{
   return with(crmUserConfig) {
      CrmUserRequest(login, password, captcha)
    }

  }
}