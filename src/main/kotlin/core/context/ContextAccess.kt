package core.context

import core.context.constant.AppConfig
import core.context.constant.CrmUserConfig
import core.context.constant.DatabaseClientConfig
import core.context.constant.StaticContextHolder
import core.context.constant.WireMockClientConfig
import core.context.dynamic.DynamicContext
import core.context.dynamic.DynamicContextHolder
import core.http.response.TafResponse

val staticContext: AppConfig = StaticContextHolder.getContext()
val dynamicContext: DynamicContext = DynamicContextHolder.getContext()
var serviceResponse: TafResponse? = dynamicContext.sessionContext.serviceResponse
var authUserTokenValue: String? = dynamicContext.sessionContext.authUserTokenValue
var crmUserConfig: CrmUserConfig = staticContext.cmrUserConfig
var wireMockClientConfig : WireMockClientConfig = staticContext.wireMockClientConfig
var databaseClientConfig : DatabaseClientConfig = staticContext.databaseClientConfig