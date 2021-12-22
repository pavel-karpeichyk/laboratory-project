import core.application.app_config.config.AppConfigProvider
import core.holder.DynamicContext
import core.holder.DynamicContextHolder
import core.holder.DynamicContextHolder.dynamicConfig
import core.holder.StaticContextHolder
import core.holder.StaticContextHolder.appConfig
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeAll
  fun configContext() {
    appConfig = AppConfigProvider().getAppConfig()
    dynamicConfig= DynamicContext()
  }

  @AfterAll
  fun cleanup() {
    StaticContextHolder.clearContext()
    DynamicContextHolder.clearContext()
  }
}