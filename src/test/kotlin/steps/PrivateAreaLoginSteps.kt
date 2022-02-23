package steps

import core.personal_user_data.PersonalUserDataConfig
import core.ui.pages.PrivateAreaLoginPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PrivateAreaLoginSteps {

  private val logger: Logger = LogManager.getLogger()
  private val crmLoginPage: PrivateAreaLoginPage by lazy { PrivateAreaLoginPage() }

  fun loginToPrivateArea(personalUserDataConfig: PersonalUserDataConfig, code : String) {
    logger.info("Login in Private Area")
    crmLoginPage.apply {
      openPage()
      verifyPageOpened()
      clickAcceptCookiesButton()
      setPassportNumber(personalUserDataConfig.passportIdentificationNumber)
      clickAuthorizeButton()
      setSmsCodeField(code)
    }
  }
}