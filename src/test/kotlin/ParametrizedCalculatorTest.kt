import core.application.elements.Browser.verifyCurrentUrl
import core.application.pages.RegistrationPage
import core.driver.provider.BrowserType
import core.driver.provider.DriverConfigSetter
import core.taf_context.static_context.SystemPropertiesHolder.BROWSER_TYPE_SYSTEM_PROPERTY_NAME
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import steps.LandingPageSteps
import java.lang.System.clearProperty
import java.lang.System.setProperty

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParametrizedCalculatorTest : BaseUITest() {

  private val loanDays: String = "7"
  private val amount: String = "100"

  @ParameterizedTest(name = "Submit Landing Page calculator values and verify redirect on Registration Page")
  @EnumSource(BrowserType::class)
  fun `Submit Landing Page calculator values and verify redirect on Registration Page`(browserType: BrowserType) {
    val expectedUrl: String = RegistrationPage().getPageUrl()
    setProperty(BROWSER_TYPE_SYSTEM_PROPERTY_NAME, browserType.name)
    DriverConfigSetter().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCoockiesButton()
      fillCalculatorForm(amount, loanDays)
      clickRequestButton()
    }
    verifyCurrentUrl(expectedUrl)
  }

  @AfterEach
  fun cleanProperty() {
    clearProperty(BROWSER_TYPE_SYSTEM_PROPERTY_NAME)
  }
}
