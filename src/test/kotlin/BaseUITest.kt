import com.codeborne.selenide.Selenide.closeWebDriver
import core.context.constant.AppConfigProvider
import core.context.constant.StaticContextHolder
import core.context.dynamic.DynamicContext
import core.context.dynamic.DynamicContextHolder
import core.ui.driver.setter.DriverConfigSetter
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUITest {

  @BeforeAll
  fun configContext() {
    DriverConfigSetter().setDriverConfig()
    StaticContextHolder.tafContext = AppConfigProvider().getAppConfig()
    DynamicContextHolder.tafContext = DynamicContext()
  }

  @AfterEach
  fun closeDriver() {
    closeWebDriver()
  }

  @AfterAll
  fun cleanup() {
    StaticContextHolder.clearContext()
    DynamicContextHolder.clearContext()
  }
}