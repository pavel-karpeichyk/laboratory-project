package steps

import core.context.constant.CrmUserConfig
import core.context.staticContext
import core.ui.pages.CrmLoginPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class CrmLoginPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val crmLoginPage: CrmLoginPage by lazy { CrmLoginPage() }

  fun loginToCrm(crmUserConfig: CrmUserConfig = staticContext.cmrUserConfig) {
    logger.info("Login in user area")
    crmLoginPage.apply {
      openPage()
      verifyPageOpened()
      with(crmUserConfig) {
        setLogin(login)
        setPassword(password)
        setCaptcha(captcha)
        submitLoginButton()
      }
    }
  }
}