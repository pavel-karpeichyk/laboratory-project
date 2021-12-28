import core.application.app_config.config.AppConfigProvider
import core.holder.dynamic_context_holder.DynamicContext
import core.holder.dynamic_context_holder.DynamicContextHolder
import core.holder.dynamic_context_holder.DynamicContextHolder.dynamicConfig
import core.holder.static_context_holder.StaticContextHolder
import core.holder.static_context_holder.StaticContextHolder.appConfig
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeAll
  fun configContext() {
    appConfig = AppConfigProvider().getAppConfig()
    dynamicConfig = DynamicContext()
  }

  @AfterAll
  fun cleanup() {
    StaticContextHolder.clearContext()
    DynamicContextHolder.clearContext()
  }
}