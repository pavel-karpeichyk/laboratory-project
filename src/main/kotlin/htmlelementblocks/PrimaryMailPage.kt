package htmlelementblocks

import driver.Driver
import driver.Driver.Companion.getDriver
import driver.DriverType
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory

class PrimaryMailPage {
  var searchElement: SearchField?=null
  var yandexEmailMenu: YandexEmailMenu?=null
  val driver: WebDriver = getDriver(DriverType.CHROME)

  init {
    PageFactory.initElements(HtmlElementDecorator(HtmlElementLocatorFactory(driver)), this)
  }

}