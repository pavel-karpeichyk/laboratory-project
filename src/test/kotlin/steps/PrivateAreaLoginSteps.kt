package steps

import core.personal_user_data.PersonalUserDataConfig
import core.ui.elements.Browser
import core.ui.elements.Browser.verifyCurrentUrl
import core.ui.pages.LoanDetailPage
import core.ui.pages.PrivateAreaLoginPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PrivateAreaLoginSteps {

  private val logger: Logger = LogManager.getLogger()
  private val crmLoginPage: PrivateAreaLoginPage by lazy { PrivateAreaLoginPage() }
  private val loanDetailPage: LoanDetailPage by lazy { LoanDetailPage() }

  fun privateAreaLogin(personalUserDataConfig: PersonalUserDataConfig) {
    logger.info("Login in Private Area")
    crmLoginPage.apply {
      openPage()
      clickAcceptCookiesButton()
      fillPassportNumber(personalUserDataConfig.passportIdentificationNumber)
      clickAuthorizeButton()
      fillSmsCodeField()
      verifyCurrentUrl(loanDetailPage.getPageUrl())
    }
  }
}