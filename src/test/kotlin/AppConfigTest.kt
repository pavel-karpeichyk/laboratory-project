import core.application.app_config.config.AppConfigProvider
import core.holder.StaticContextHolder.appConfic
import core.holder.StaticContextHolder.clearContext
import core.holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_LOGIN
import core.holder.SystemPropertiesHolder.SYSTEM_PROPERTY_APP_CONFIG_PASSWORD
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.lang.System.clearProperty
import java.lang.System.setProperty

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppConfigTest {

  private val expectedPass: String = "1234"
  private val expectedLogin: String = "Pavel"
  lateinit var actualPass: String
  lateinit var actualLogin: String

  @Test
  fun `verify config after setting and reading system properties`() {
    setProperty(SYSTEM_PROPERTY_APP_CONFIG_PASSWORD, expectedPass)
    setProperty(SYSTEM_PROPERTY_APP_CONFIG_LOGIN, expectedLogin)
    appConfic = AppConfigProvider().getAppConfig()
    actualPass = appConfic?.pass!!
    actualLogin = appConfic?.user!!
    assertEquals(expectedLogin, actualLogin, " Doesn't match")
    assertEquals(expectedPass, actualPass, "Doesn't match")
  }

  @AfterAll
  fun cleanup() {
    clearProperty(SYSTEM_PROPERTY_APP_CONFIG_PASSWORD)
    clearProperty(SYSTEM_PROPERTY_APP_CONFIG_LOGIN)
  }
}