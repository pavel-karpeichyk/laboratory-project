package service

import org.openqa.selenium.By
import service.DataReader.Companion.locatorsProperty
import service.LocatorType.*
import java.io.FileInputStream
import java.util.*

class DataReader {

  companion object {
    private val  credentialFileInput: FileInputStream = FileInputStream("src/test/resources/credential.properties")
    private val locatorsFileInput: FileInputStream = FileInputStream("src/main/resources/locators.properties")
    var credentialProperty: Properties = Properties()
    var locatorsProperty: Properties = Properties()

    init {
      credentialProperty.load(credentialFileInput)
      locatorsProperty.load(locatorsFileInput)
    }

    fun getValue(key: String, properties: Properties): By {
      var propertyValue: String = properties.getProperty(key)
      var locatorsItems: Array<String> = propertyValue.split("=", limit = 2).toTypedArray()
      var locatorType: LocatorType = valueOf(locatorsItems[0])
      return when (locatorType) {
        id -> By.id(locatorsItems[1])
        css -> By.cssSelector(locatorsItems[1])
        xpath -> By.xpath(locatorsItems[1])
        else -> throw IllegalArgumentException("Don't match!")
      }
    }

    fun getCredential(key: String, properties: Properties): String {
      return properties.getProperty(key)
    }
  }
}

fun main() {
// print(DataReader.getValue("HomePage.emailButton", DataReader.locatorsProperty))
  //print(DataReader.getValue("login", DataReader.credentialProperty))
  println(DataReader.getValue("AutherizationPage.passwordField", locatorsProperty))
  println(DataReader.getValue("AutherizationPage.emailField", locatorsProperty))
}
