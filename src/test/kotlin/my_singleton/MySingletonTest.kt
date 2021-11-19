package my_singleton


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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