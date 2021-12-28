import core.api.crm.controller.CrmController
import core.holder.dynamic_context_holder.DynamicContext
import core.holder.dynamic_context_holder.DynamicContextHolder
import core.holder.dynamic_context_holder.DynamicContextHolder.getContext
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class SessionContextObserverTest : BaseTest() {

  @Test
  fun `verify that AuthUser cookie value set in SessionContext when make CRM authorisation service call`() {
    CrmController().authCrm()
    var expectedAuthUserTokenValue: String? = getContext<DynamicContext>().sessionContext.authUserTokenValue
    assertNotNull(expectedAuthUserTokenValue, "AuthUserTokenValue doesn't set in session context")
  }
}