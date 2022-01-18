package core.api.crm

import core.api.crm.model.CrmUserRequest
import core.context.crmUserConfig

class CrmRequestBuilder {

  fun getCrmUserRequest(): CrmUserRequest{
   return with(crmUserConfig) {
      CrmUserRequest(login, password, captcha)
    }
  }
}