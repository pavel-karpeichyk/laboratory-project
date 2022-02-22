package steps

import core.personal_user_data.PersonalUserDataConfig
import core.ui.pages.PersonalPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PersonalPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val personalPage: PersonalPage by lazy { PersonalPage() }

  fun openPersonalPage() {
    personalPage.openPage()
  }

  fun getPersonalPageUrl(): String {
    return personalPage.getPageUrl()
  }

  fun getUserData(person: PersonalUserDataConfig) {
    logger.info("Get personal data")
  return  with(personalPage) {
      person.name = getName()!!
      person.surname = getSurname()!!
      person.passportIdentificationNumber = getPassportNumber()!!
      person.email = getEmail()!!
    }
  }
}
