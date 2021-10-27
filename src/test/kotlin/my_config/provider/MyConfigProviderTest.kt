package my_config.provider

import my_config.model.MyModelConfig
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class MyConfigProviderTest {

  @ParameterizedTest(name = "Verify getContentFromFile returns config from file {arguments}")
  @EnumSource(FileType::class)
  fun `verify getContentFromFile returns config from file `(fileType: FileType) {
    val expectedContent: MyModelConfig = MyModelConfig("127.0.0.1", "robocop.com", "Robocop", "1984")
    val actualContent: MyModelConfig = MyConfigProvider.getContentFromFile(fileType)

    assertAll(
      {

        assertEquals(
          expectedContent, actualContent,
          "Content from file doesn't equal content from $fileType"

        )},


      { assertEquals(
          expectedContent.myHost,
          actualContent.myHost,
          "Value field myHost doesn't equals value from file $fileType"
        )},


      {  assertEquals(
          expectedContent, actualContent,
          "Doesn't ignored unknown fields in file $fileType"
        )},

      {  assertEquals(
          expectedContent.ignoreNullableInModel,
          actualContent.ignoreNullableInModel,
          "Value field ignoreNullableInModel doesn't equals value from file $fileType"
        )}

      )
  }
}
