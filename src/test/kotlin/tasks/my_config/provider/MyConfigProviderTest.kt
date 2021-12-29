package tasks.my_config.provider

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import tasks.my_config.model.MyModelConfig

class MyConfigProviderTest {

  @ParameterizedTest(name = "Verify getContentFromFile returns config from file {arguments}")
  @EnumSource(FileType::class)
  fun `verify getContentFromFile returns config from file `(fileType: FileType) {
    val expectedContent: MyModelConfig = MyModelConfig("127.0.0.1", "robocop.com", "Robocop", "1984")
    val actualContent: MyModelConfig = MyConfigProvider.getContentFromFile(fileType)
    assertEquals(
      expectedContent, actualContent,
      "Content from file doesn't equal content from $fileType"
    )
  }
}