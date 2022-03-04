import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import core.personal_user_data.PersonalUserDataConfig
import core.ui.elements.Browser.clearCookie
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import steps.BorrowersPageSteps
import steps.CrmLoginPageSteps
import steps.EsMySqlDatabaseSteps
import steps.PrivateAreaSteps

class BorrowerVerificationTest : BaseUITest() {

  private lateinit var borrowerId: String
  private lateinit var userData: Map<String, Any>
  private lateinit var tafDatabaseClient: TafDatabaseClient
  private lateinit var actualUserValueUi: PersonalUserDataConfig
  private lateinit var expectedUserValueDb: PersonalUserDataConfig
  private val esMySqlDatabaseSteps: EsMySqlDatabaseSteps by lazy { EsMySqlDatabaseSteps() }
  private val privateAreaSteps: PrivateAreaSteps by lazy { PrivateAreaSteps() }
  private val borrowersPageSteps: BorrowersPageSteps by lazy { BorrowersPageSteps() }

  @BeforeAll
  fun initClient() {
    tafDatabaseClient = TafDatabaseClient()
    expectedUserValueDb = PersonalUserDataConfig()
  }

  @BeforeEach
  fun prepareCondition() {
    CrmLoginPageSteps().loginToCrm()
    borrowersPageSteps.apply {
      openCrmBorrowersPage()
      borrowerId = searchBorrowerUsingFilterAndGetBorrowerId()
    }
    userData = esMySqlDatabaseSteps.getUserPassportNumber(borrowerId).toMutableMap()
    expectedUserValueDb.passportIdentificationNumber = userData["passport_identification_number"].toString()
    clearCookie()
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDatabaseClient.closeDbConnection()
  }

  @Test
  fun `verify borrower verification data  from Ui equals the same data from database`() {
    privateAreaSteps.apply {
      loginInPrivateArea(expectedUserValueDb)
      openPersonPage()
      actualUserValueUi = getUserData()
    }
    esMySqlDatabaseSteps.apply {
      val mapId: Map<String, Any> =
        getUserAccountIdAndPersonalDataId(borrowerId)
      val userAccountId: String = mapId["user_account_id"].toString()
      val personalDataId: String = mapId["personal_data_id"].toString()
      (userData as MutableMap<String, Any>).putAll(getUserEmail(userAccountId).toMutableMap())
      (userData as MutableMap<String, Any>).putAll(getUserNameSurnameBirthday(personalDataId))
      expectedUserValueDb = jacksonObjectMapper().convertValue(userData, PersonalUserDataConfig::class.java)
    }
    assertEquals(expectedUserValueDb, actualUserValueUi,"Expected user data doesn't match actual")
  }
}
