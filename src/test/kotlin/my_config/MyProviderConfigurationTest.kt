package my_config

import my_config.model.MyModelConfiguration
import my_config.provider.FileType
import my_config.provider.Provider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class MyProviderConfigurationTest {

  @ParameterizedTest(name = "Verify to read of the {arguments}")
  @EnumSource(FileType::class)
  fun `verify content from file `(fileType: FileType) {
    val expectedContent: MyModelConfiguration = MyModelConfiguration("robocop.com", "Robocop", "1984")
    val actualContent: MyModelConfiguration = Provider.getContentFromFile(fileType)
    assertEquals( expectedContent, actualContent,
      "Content from file doesn't equal content from $fileType"
    )
  }
}