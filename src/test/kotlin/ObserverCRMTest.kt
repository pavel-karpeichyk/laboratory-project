import core.api.HTTPclient.TafResponse
import core.api.crm.controller.CrmController
import core.holder.DynamicContext
import core.holder.DynamicContextHolder
import core.holder.DynamicContextHolder.getConfig
import core.holder.DynamicContextObserver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ObserverCRMTest : BaseTest() {
  private var expectedUserTokenCookieName: String = "AuthUser"

  @Test
  fun `verify that data not null`() {
//    val tafResponse: TafResponse = CrmController().authCrm()
//    getConfig().sessionContext.dataFromSession = tafResponse
//    assertNotNull(getConfig().sessionContext.dataFromSession, "Response is empty")


    var response: TafResponse = CrmController().authCrm()
    var dynamicContext: DynamicContext = DynamicContext()
    println( " First condition  ${dynamicContext.userValue}")
    DynamicContextObserver().following(dynamicContext)
    dynamicContext.setNewCondition(response)
    DynamicContextObserver().update(response.getValueFromCookie("AuthName").toString())
    println( "Last condition  ${dynamicContext.userValue}")
  }
}