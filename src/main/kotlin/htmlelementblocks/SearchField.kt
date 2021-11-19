package htmlelementblocks

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.annotations.Name
import ru.yandex.qatools.htmlelements.element.Button
import ru.yandex.qatools.htmlelements.element.TextInput

@Name("Search Block")
@FindBy(xpath = "//div[@class='PSHeader-Left']")
class SearchField {
  @Name("Search Field")
  @FindBy (xpath = "//*[@id='js-apps-container']//input[@type='text']")
  var searchField: TextInput?=null

  @Name("Search button")
  @FindBy(xpath = "//button[@type='submit']")
  var searchButton: Button?=null

  fun searchFor(text: String){
   // searchField?.sendKeys(text) //conflict with Selenide
   // searchButton?.click()

  }




}