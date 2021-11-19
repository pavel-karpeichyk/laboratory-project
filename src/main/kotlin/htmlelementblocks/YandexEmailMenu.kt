package htmlelementblocks

import org.openqa.selenium.support.FindBy
import ru.yandex.qatools.htmlelements.annotations.Name
import ru.yandex.qatools.htmlelements.element.Button

@Name("Yandex Email Menu")
@FindBy(xpath = "PSHeader-Center")
class YandexEmailMenu {

  @Name("Email Button")
  @FindBy(xpath = "//div[@class='PSHeaderIcon-Image PSHeaderIcon-Image_Mail PSHeaderIcon-Image_theme_light']")
  var emailButton: Button? = null

  @Name("Disc Button")
  @FindBy(xpath = "//div[@class='PSHeaderIcon-Image PSHeaderIcon-Image_Disk PSHeaderIcon-Image_theme_light']")
  var discButton: Button? = null

  @Name("Tele bridge  Button")
  @FindBy(xpath = "//div[@class='PSHeaderIcon-Image PSHeaderIcon-Image_Telemost PSHeaderIcon-Image_theme_light']")
  var telemostButton: Button? = null

  @Name("More App Button")
  @FindBy(xpath = "//div[@class='PSHeaderIcon-Image PSHeaderIcon-Image_More PSHeaderIcon-Image_theme_light']")
  var moreAppButton: Button? = null

  fun goToDisc() {
   // discButton?.click() // conflict with Selenide
  }

  fun goToNotes(){
   // moreAppButton?.click() // conflict with Selenide
    // click to Notes button
  }
}