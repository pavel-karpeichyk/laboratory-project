import core.context.constant.AppConfigProvider
import core.context.constant.StaticContextHolder
import core.context.dynamic.DynamicContext
import core.context.dynamic.DynamicContextHolder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeAll
  fun configContext() {
    StaticContextHolder.tafContext = AppConfigProvider().getAppConfig()
    DynamicContextHolder.tafContext = DynamicContext()
  }

  @AfterAll
  fun cleanup() {
    StaticContextHolder.clearContext()
    DynamicContextHolder.clearContext()
  }
}