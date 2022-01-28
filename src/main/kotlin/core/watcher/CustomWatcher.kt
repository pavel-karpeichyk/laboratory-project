package core.watcher

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors

class CustomWatcher : TestWatcher, AfterAllCallback {
  var listTestResultStatusType: ArrayList<TestResultStatusType> = ArrayList()
  private val logger: Logger = LogManager.getLogger()

  override fun testDisabled(context: ExtensionContext?, reason: Optional<String>?) {
    logger.info(
      "Test Disabled for test ${context?.displayName}: " +
          "with reason :- ${reason?.orElse("No reason")}"
    )
    listTestResultStatusType.add(TestResultStatusType.DISABLED)
  }

  override fun testSuccessful(context: ExtensionContext?) {
    logger.info("Test Successful for test ${context?.displayName}: ")
    listTestResultStatusType.add(TestResultStatusType.SUCCESSFUL)
  }

  override fun testAborted(context: ExtensionContext?, cause: Throwable?) {
    logger.info("Test Aborted for test ${context?.displayName}: ")
    listTestResultStatusType.add(TestResultStatusType.ABORTED)
  }

  override fun testFailed(context: ExtensionContext?, cause: Throwable?) {
    logger.info("Test Failed for test ${context?.displayName}: ")
    listTestResultStatusType.add(TestResultStatusType.FAILED)
    AllureAttachment().saveScreenshot()
  }

  override fun afterAll(context: ExtensionContext?) {
    logger.info("${context?.displayName} -> STOP")
    var summary: Map<TestResultStatusType, Long> = listTestResultStatusType.stream()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    logger.info("REPORT -> Test result summary for ${context?.displayName} ${summary.toString()}")
  }
}