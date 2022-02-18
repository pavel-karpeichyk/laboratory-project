package steps

import core.ui.pages.PersonalPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PersonalPageSteps {

  private val personalPage: PersonalPage by lazy { PersonalPage() }
  private val logger: Logger = LogManager.getLogger()

  fun openPersonalPage(){
    personalPage.openPage()
  }

  fun getPersonalPageUrl(): String {
    return personalPage.getPageUrl()
  }

  fun getUserData() {
    logger.info("Get personal data")
    with(personalPage) {
      getName()
      getSurname()
      getPassportNumber()
      getEmail()
    }
  }
}
