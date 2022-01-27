import core.watcher.Ban
import core.watcher.CustomWatcher
import core.watcher.CustomerWatcherBeforeTest
import core.watcher.ValuerExecutionCondition
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CustomWatcher::class, CustomerWatcherBeforeTest::class, ValuerExecutionCondition::class)
class CustomerWatcherApiUnitTest {

  @Test
  fun `given false is expected true test aborted `() {
    Assumptions.assumeTrue(false)
  }

  @Test
  fun `given true is true when test passed `() {
    assertTrue(true)
  }

  @Test
  fun `given false is expected true test failed `() {
    assertTrue(false)
  }

  @Disabled
  @Test
  fun `given true is true when test disabled`() {
    assertTrue(true)
  }

  @Ban
  @Test
  fun `given Ban annotation when test disabled `() {
    assertTrue(true)
  }
}