import core.api.crm.controller.CrmController
import core.context.authUserTokenValue
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class SessionContextObserverTest : BaseUITest() {

  @Test
  fun `verify that AuthUser cookie value set in SessionContext when make CRM authorisation service call`() {
    CrmController().authCrm()
    var expectedAuthUserTokenValue: String? = authUserTokenValue
    assertNotNull(expectedAuthUserTokenValue, "AuthUserTokenValue doesn't set in session context")
  }
}