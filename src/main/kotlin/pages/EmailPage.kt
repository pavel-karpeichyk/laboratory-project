package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import service.DataReader
import service.DataReader.Companion.getValue

class EmailPage(): BasePage () {

  override fun openPage() {
  }

private var wait: WebDriverWait= WebDriverWait(driver, 10)

  //@FindBy(xpath = "//div[@class='user-pic user-pic_has-plus_ user-account__pic']")
  private var profileButton: By = getValue("EmailPage.profileButton", DataReader.locatorsProperty)

  //@FindBy(xpath = "//span[@class='user-account__subname']/parent::span")
  private var userAccountName: By =getValue("EmailPage.userAccountName", DataReader.locatorsProperty)

  fun clickProfileButton(){
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(profileButton)))
    driver.findElement(profileButton).click()
  }

  fun getUserName(): String{
    return driver.findElement(userAccountName).text!!
  }

fun getCountEmail(): Int{
  var emails: List <WebElement> =driver.findElements(By.xpath("//span[@class='mail-MessageSnippet-FromText']"))
  return emails.size
}
}