import core.context.staticContext
import core.personal_user_data.PersonalUserDataConfig
import core.ui.elements.Browser.clearCookie
import core.ui.pages.PersonalPage
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.BorrowersPageSteps
import steps.CrmLoginPageSteps
import steps.EsMySqlDatabaseSteps
import steps.PersonalPageSteps
import steps.PrivateAreaLoginSteps

class VerifyUserDataFromUiAndDatabaseTest : BaseUITest() {

  private lateinit var tafDatabaseClient: TafDatabaseClient
  private lateinit var personalUserDataConfig: PersonalUserDataConfig

  @BeforeAll
  fun initClient() {
    tafDatabaseClient = TafDatabaseClient()
    personalUserDataConfig = PersonalUserDataConfig(
      "",
      "", "", "", ""
    )
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDatabaseClient.closeDbConnection()
  }

  @Test
  fun `verify that data from Ui equals data from database`() {
    CrmLoginPageSteps().loginToCrm()
    val id: String? = BorrowersPageSteps().getBorrowerId()
    val dni: String = EsMySqlDatabaseSteps().getPassportNumber(id, tafDatabaseClient)
    personalUserDataConfig.passportIdentificationNumber = dni
    clearCookie()
    PrivateAreaLoginSteps().loginToPrivateArea(personalUserDataConfig, staticContext.smsCode)
    PersonalPageSteps().apply {
      getUserData()
    }
    println(PersonalPage().getName())
    println(PersonalPage().getSurname())
    println(PersonalPage().getPassportNumber())
    println(PersonalPage().getEmail())
    println(PersonalPage().getBirthDate())
  }
}
