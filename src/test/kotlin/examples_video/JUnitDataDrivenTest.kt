package examples_video

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
  class JUnitDataDrivenTest ( ) {

  private  val driver: WebDriver = getDriver(DriverType.CHROME)
  private val urlGoogle: String = "https://www.google.by"



  @ParameterizedTest
  @MethodSource("data")
  fun `google search test`(searchText: String){
    driver.get(urlGoogle)
    driver.manage().window().maximize()
    val inputField: WebElement = driver.findElement(By.name("q"))
    inputField.sendKeys(searchText)
  }

@Suppress
   fun data(): Stream<Arguments> {
    return Stream.of(
      Arguments.of("Selenium"),
      Arguments.of("Hello World"),
      Arguments.of("Kotlin")
    )
  }

}

