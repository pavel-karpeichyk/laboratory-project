import com.codeborne.selenide.Selenide.closeWebDriver
import core.application.app_config.config.AppConfigProvider
import core.holder.StaticContextHolder
import core.holder.StaticContextHolder.appConfic
import core.holder.StaticContextHolder.clearContext
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUITest {

  @BeforeAll
  fun `configContext`() {
    appConfic = AppConfigProvider().getAppConfig()
  }

  @AfterEach
  fun closeDriver() {
    closeWebDriver()
  }

  @AfterAll
  fun cleanup() {
    clearContext()
  }
}