import core.application.app_config.model.AppConfig
import core.holder.static_context_holder.StaticContextHolder.getContext
import core.holder.static_context_holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_LOGIN
import core.holder.static_context_holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_PASSWORD
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.lang.System.clearProperty
import java.lang.System.setProperty

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppConfigTest : BaseTest() {

  private val expectedPass: String = "1234"
  private val expectedLogin: String = "Pavel"
  lateinit var actualPass: String
  lateinit var actualLogin: String

  @Test
  fun `verify config with system properties`() {
    setProperty(SYSTEM_PROPERTY_APP_CONFIG_PASSWORD, expectedPass)
    setProperty(SYSTEM_PROPERTY_APP_CONFIG_LOGIN, expectedLogin)
    actualPass = getContext<AppConfig>().pass
    actualLogin = getContext<AppConfig>().user
    assertEquals(expectedLogin, actualLogin, "Expected user $expectedLogin doesn't match actual $actualLogin")
    assertEquals(expectedPass, actualPass, "Expected password $expectedPass doesn't match  actual $actualPass")
  }

  @AfterEach
  fun cleanProperties() {
    clearProperty(SYSTEM_PROPERTY_APP_CONFIG_PASSWORD)
    clearProperty(SYSTEM_PROPERTY_APP_CONFIG_LOGIN)
  }
}