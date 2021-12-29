package tasks.my_config.provider

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import tasks.my_config.model.MyModelConfig

class MyConfigProviderSystemPropertyTest {

  companion object {
    private const val FILE_TYPE_SYSTEM_PROPERTY_NAME = "FILE_TYPE_SYSTEM_PROPERTY"
  }

  @BeforeEach
  fun `set value in system variable`() {
    System.setProperty(FILE_TYPE_SYSTEM_PROPERTY_NAME, FileType.YAML.name)
  }

  @Test
  fun `verify getContentFromFile returns config from file `() {
    val fileType: FileType = FileType.valueOf(System.getProperty(FILE_TYPE_SYSTEM_PROPERTY_NAME))
    val expectedContent: MyModelConfig = MyModelConfig("127.0.0.1", "robocop.com", "Robocop", "1984")
    val actualContent: MyModelConfig = MyConfigProvider.getContentFromFile(fileType)
    Assertions.assertEquals(
      expectedContent, actualContent,
      "Content from file doesn't equal content from $fileType"
    )
  }

  @AfterEach
  fun `delete system variable`() {
    System.clearProperty(FILE_TYPE_SYSTEM_PROPERTY_NAME)
  }
}