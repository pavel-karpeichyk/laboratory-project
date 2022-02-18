package steps

import core.ui.pages.PrivateAreaLoginPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class PrivateAreaLoginSteps {

  private val crmLoginPage: PrivateAreaLoginPage by lazy { PrivateAreaLoginPage() }
  private val logger: Logger = LogManager.getLogger()

  fun privateAreaLogin(number: String) {
    logger.info("Login in Private Area")
    crmLoginPage.apply {
      openPage()
      clickAcceptCookiesButton()
      fillPassportNumber(number)
      clickAuthorizeButton()
      fillSmsCodeField()

    }
  }
}