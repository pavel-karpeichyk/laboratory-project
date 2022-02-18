package steps

import core.context.crmUserConfig
import core.context.staticContext
import core.ui.pages.CrmLoginPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class CrmLoginPageSteps {

  private val crmLoginPage: CrmLoginPage by lazy { CrmLoginPage() }
  private val logger: Logger = LogManager.getLogger()

  fun openCrmPage(){
    logger.info("Open crm page")
    CrmLoginPage().openPage()
  }

  fun crmLogin(){
    crmLoginPage.apply {
      openPage()
      with(crmUserConfig) {
        setLogin(login)
        setPassword(password)
        setCaptcha(captcha)
        submitLoginButton()
      }
    }
  }

}