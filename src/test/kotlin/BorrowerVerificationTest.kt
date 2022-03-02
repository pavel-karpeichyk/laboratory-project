import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import core.personal_user_data.PersonalUserDataConfig
import core.ui.elements.Browser.clearCookie
import database_client.EsMoneymanSqlQuery.selectDniNameSurnameBirthdayByPersonalDataId
import database_client.EsMoneymanSqlQuery.selectUserAccountIdAndPersonalDataIdByBorrowerId
import database_client.EsMoneymanSqlQuery.selectUserEmailByUserAccountId
import database_client.EsMoneymanSqlQuery.selectUserPassportNumberByBorrowerId
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.BorrowersPageSteps
import steps.CrmLoginPageSteps
import steps.EsMySqlDatabaseSteps
import steps.PrivateAreaSteps

class BorrowerVerificationTest : BaseUITest() {

  private lateinit var tafDatabaseClient: TafDatabaseClient
  private lateinit var expectedUser: PersonalUserDataConfig
  private lateinit var actualUser: PersonalUserDataConfig
  private val esMySqlDatabaseSteps: EsMySqlDatabaseSteps by lazy { EsMySqlDatabaseSteps() }
  private val privateAreaSteps: PrivateAreaSteps by lazy { PrivateAreaSteps() }

  @BeforeAll
  fun initClient() {
    tafDatabaseClient = TafDatabaseClient()
    expectedUser = PersonalUserDataConfig()
    actualUser = PersonalUserDataConfig()
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDatabaseClient.closeDbConnection()
  }

  @Test
  fun `verify borrower verification data  from Ui equals the same data from database`() {
    CrmLoginPageSteps().loginToCrm()
    val borrowerId: String = BorrowersPageSteps().getBorrowerId()
    var userData: MutableMap<String, Any> =
      esMySqlDatabaseSteps.getUserDataById(borrowerId, tafDatabaseClient, selectUserPassportNumberByBorrowerId)
    actualUser.passportIdentificationNumber = esMySqlDatabaseSteps.getValueFromMap("DNI", userData)
    clearCookie()
    privateAreaSteps.apply {
      loginInPrivateArea(actualUser)
      expectedUser = getUserData()
    }
    esMySqlDatabaseSteps.apply {
      val mapId: MutableMap<String, Any> =
        getUserDataById(borrowerId, tafDatabaseClient, selectUserAccountIdAndPersonalDataIdByBorrowerId)
      val userAccountId: String = getValueFromMap("user_account_id", mapId)
      val personalDataId: String = getValueFromMap("personal_data_id", mapId)
      userData = getUserDataById(userAccountId, tafDatabaseClient, selectUserEmailByUserAccountId)
      userData.putAll(getUserDataById(personalDataId, tafDatabaseClient, selectDniNameSurnameBirthdayByPersonalDataId))
      actualUser = jacksonObjectMapper().convertValue(userData, PersonalUserDataConfig::class.java)
    }
    assertEquals(expectedUser, actualUser, "Expected user data doesn't match actual")
  }
}
