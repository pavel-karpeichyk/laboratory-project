import core.api.crm.controller.CrmController
import core.holder.DynamicContextHolder.getConfig
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class SessionContextObserverTest : BaseTest() {

  @Test
  fun `verify that AuthUser cookie value set in SessionContext when make CRM authorisation service call`() {
    CrmController().authCrm()
    var expectedAuthUserTokenValue: String? = getConfig().sessionContext.authUserTokenValue
    assertNotNull(expectedAuthUserTokenValue, "AuthUserTokenValue doesn't set in session context")
  }
}