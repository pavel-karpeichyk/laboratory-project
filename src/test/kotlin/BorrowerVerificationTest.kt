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
  private lateinit var userData: MutableMap<String, Any>
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
  fun `Private Area - UI - Personal Page user data is the same as the user data in the database`() {
    privateAreaSteps.apply {
      loginToPrivateArea(expectedUserValueDb)
      openPersonPage()
      actualUserValueUi = actualUiUserData()
    }

    esMySqlDatabaseSteps.apply {
      userData.putAll(getUserDatabaseData(borrowerId))
      expectedUserValueDb = jacksonObjectMapper().convertValue(userData, PersonalUserDataConfig::class.java)
    }
    assertEquals(expectedUserValueDb, actualUserValueUi,"Expected user data doesn't match actual")
  }
}
