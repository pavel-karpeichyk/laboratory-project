package steps

import core.personal_user_data.PersonalUserDataConfig
import core.ui.elements.Browser.verifyCurrentUrl
import core.ui.pages.LoanDetailPage
import core.ui.pages.PersonalPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PersonalPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val personalPage: PersonalPage by lazy { PersonalPage() }
  private lateinit var person: PersonalUserDataConfig

  fun getUserData(): PersonalUserDataConfig {

    logger.info("Get personal data")
    with(personalPage) {
     LoanDetailPage().verifyPageOpened()
      openPage()
      verifyPageOpened()
      person = PersonalUserDataConfig(
        name = getName()!!,
        surname = getSurname()!!,
        passportIdentificationNumber = getPassportNumber()!!,
        email = getEmail()!!,
        dateOfBirth = getBirthDate()!!
      )
    }
    return person
  }
}
