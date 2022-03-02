package steps

import core.convecters.DateConverter.getDateInSelectedFormat
import core.convecters.DateConverter.getMonthAsNumber
import core.personal_user_data.PersonalUserDataConfig
import core.ui.pages.LoanDetailPage
import core.ui.pages.PersonalPage
import core.ui.pages.PrivateAreaLoginPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PrivateAreaSteps {

  private val logger: Logger = LogManager.getLogger()
  private val personalPage: PersonalPage by lazy { PersonalPage() }
  private val loanDetailPage: LoanDetailPage by lazy { LoanDetailPage() }
  private val privateAreaLoginPage: PrivateAreaLoginPage by lazy { PrivateAreaLoginPage() }
  private val borrowerDateFormat: String = "yyyy-MM-dd"
  private val dateFormatPersonalPage: String = "yyyy-MM-d"

  fun loginInPrivateArea(personalUserDataConfig: PersonalUserDataConfig) {
    logger.info("Login in Private Area")
    privateAreaLoginPage.apply {
      openPage()
      verifyPageOpened()
      clickAcceptCookiesButton()
      personalUserDataConfig.passportIdentificationNumber?.let { setPassportNumber(it) }
      clickAuthorizeButton()
      setSmsCodeField(personalUserDataConfig.smsCode)
    }
  }

  private fun getMonthIndex(): String {
    return getMonthAsNumber(personalPage.getBirthMonth())
  }

  private fun convertDateInSelectedFormat(): String {
    return getDateInSelectedFormat(getBirthDate(), dateFormatPersonalPage, borrowerDateFormat)
  }

  private fun getBirthDate(): String {
    val dayValue = personalPage.getBirthDay()
    val monthValue = getMonthIndex()
    val yearValue = personalPage.getBirthYear()
    return "$yearValue-$monthValue-$dayValue"
  }

  fun getUserData(): PersonalUserDataConfig {
    logger.info("Get personal data")
    loanDetailPage.verifyPageOpened()
    with(personalPage) {
      openPage()
      verifyPageOpened()
      return PersonalUserDataConfig(
        name = getName(),
        surname = getSurname(),
        passportIdentificationNumber = getPassportNumber(),
        email = getEmail(),
        dateOfBirth = convertDateInSelectedFormat()
      )
    }
  }
}
