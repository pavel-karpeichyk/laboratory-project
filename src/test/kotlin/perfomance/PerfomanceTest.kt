package perfomance

import core.PerformanceTestBase
import org.testng.annotations.Test

class PerfomanceTest : PerformanceTestBase() {
  @Test
  fun `perfomance test` (){
    startHarRecording()
    driver!!.get("https://www.google.com/")
    finishHarRecording()
  }
}