package core.watcher

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class CustomerWatcherBeforeTest : BeforeAllCallback {
  private val logger: Logger = LogManager.getLogger()
  override fun beforeAll(context: ExtensionContext?) {
    logger.info("${context?.displayName} -> START")
  }
}