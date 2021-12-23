import core.api.crm.controller.CrmController
import core.holder.DynamicContextHolder.getConfig
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ObserverCRMTest : BaseTest() {

  @Test
  fun `verify that value cookie AuthUser set in session context `() {
    CrmController().authCrm()
    var expectedValue: String? = getConfig().sessionContext.authUserTokenValue
    assertNotNull(expectedValue, "Value doesn't set in session context")
  }
}