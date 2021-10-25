package my_config

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import serialization_deserialization.my_config.MyModelConfiguration
import serialization_deserialization.provider.FileType
import serialization_deserialization.provider.Provider

class MyModelConfigurationTest {
  val expectedContent: MyModelConfiguration = MyModelConfiguration("robocop.com", "Robocop", "1984")
  @Test
  fun `verify content from file JSON`() {
    val actualContent: MyModelConfiguration = Provider.getContentFromFile(FileType.JSON)
    assertEquals(expectedContent, actualContent,
      "Content from file doesn't equal content from object")
  }
  @Test
  fun `verify content from file YAML`() {
    val actualContent: MyModelConfiguration = Provider.getContentFromFile(FileType.YAML)
    assertEquals(expectedContent, actualContent,
      "Content from file doesn't equal content from object")
  }
}