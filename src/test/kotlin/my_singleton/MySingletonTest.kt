package my_singleton

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MySingletonTest {
  @Test
  fun `check singleton creates only one instance`() {
    val expectedInstance: MySingleton = MySingleton.getInstance()
    val actualInstance: MySingleton = MySingleton.getInstance()
    assertEquals(expectedInstance, actualInstance,
      "Error : Was created two instances of my singleton"
    )
  }
}