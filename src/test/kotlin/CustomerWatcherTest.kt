import com.codeborne.selenide.Selenide.open
import core.ui.driver.setter.DriverConfigSetter
import core.ui.elements.Browser
import core.watcher.Ban
import core.watcher.CustomWatcher
import core.watcher.CustomerWatcherBeforeTest
import core.watcher.ExecutionConditionCustomAnnotation
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(
  CustomWatcher::class,
  CustomerWatcherBeforeTest::class,
  ExecutionConditionCustomAnnotation::class
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerWatcherTest : BaseTest() {

  private val actualUrl: String = "https://www.google.by"
  private val expectedUrl: String = "http//someurl"

  @Test
  fun `given false is expected true then test aborted`() {
    Assumptions.assumeTrue(false)
  }

  @Test
  fun `given true is true then test passed`() {
    assertTrue(true)
  }

  @Test
  fun `given false is  true then test failed`() {
    assertTrue(false)
  }

  @Disabled
  @Test
  fun `given true is true then test disabled`() {
    assertTrue(true)
  }

  @Ban
  @Test
  fun `given Ban annotation then test disabled`() {
    assertTrue(true)
  }

  @Test
  fun `given failed test then screenshot attachments`() {
    DriverConfigSetter().setDriverConfig()
    open(actualUrl)
    Browser.verifyCurrentUrl(expectedUrl)
  }
}