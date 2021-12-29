import com.codeborne.selenide.Selenide.closeWebDriver
import core.context.constant.AppConfigProvider
import core.context.constant.StaticContextHolder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseUITest {

  @BeforeAll
  fun configContext() {
    StaticContextHolder.tafContext = AppConfigProvider().getAppConfig()
  }

  @AfterEach
  fun closeDriver() {
    closeWebDriver()
  }

  @AfterAll
  fun cleanup() {
    StaticContextHolder.clearContext()
  }
}