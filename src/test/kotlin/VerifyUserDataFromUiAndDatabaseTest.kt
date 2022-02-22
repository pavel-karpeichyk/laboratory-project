import core.personal_user_data.PersonalUserDataConfig
import core.ui.elements.Browser.clearCookie
import core.ui.elements.Browser.verifyCurrentUrl
import core.ui.pages.PersonalPage
import database_client.EsMoneymanSqlQuery
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.BorrowersPageSteps
import steps.CrmLoginPageSteps
import steps.PersonalPageSteps
import steps.PrivateAreaLoginSteps

class VerifyUserDataFromUiAndDatabaseTest : BaseUITest() {

  private lateinit var tafDatabaseClient: TafDatabaseClient
  private lateinit var personalUserDataConfig: PersonalUserDataConfig

  @BeforeAll
  fun initClient() {
    tafDatabaseClient = TafDatabaseClient()
    personalUserDataConfig = PersonalUserDataConfig("",
      "","","","")
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDatabaseClient.closeDbConnection()
  }

  @Test
  fun `verify that data from Ui equals data from database`() {
    CrmLoginPageSteps().loginToCrm()
    val id = BorrowersPageSteps().getIdBorrower()
    val paramId: Map<String, Any> = mapOf("id" to "$id")
    val query = EsMoneymanSqlQuery.selectUserPassportNumberByBorrowerId
    val result = tafDatabaseClient.selectOneRow(query, paramId)
    val dni: String = result["DNI"].toString()
    personalUserDataConfig.passportIdentificationNumber = dni
    clearCookie()
    PrivateAreaLoginSteps().privateAreaLogin(personalUserDataConfig)
    with(PersonalPageSteps()) {
      openPersonalPage()
      verifyCurrentUrl(getPersonalPageUrl())
      getUserData(personalUserDataConfig)
    }
    println(PersonalPage().getName())
    println(PersonalPage().getSurname())
    println(PersonalPage().getPassportNumber())
    println(PersonalPage().getEmail())
  }
}
