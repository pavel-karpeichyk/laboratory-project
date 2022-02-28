import core.context.staticContext
import core.personal_user_data.PersonalUserDataConfig
import core.ui.elements.Browser.clearCookie
import database_client.EsMoneymanSqlQuery.selectDniNameSurnameBirthdayByPersonalDataId
import database_client.EsMoneymanSqlQuery.selectUserAccountIdAndPersonalDataIdByBorrowerId
import database_client.EsMoneymanSqlQuery.selectUserEmailByUserAccountId
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.BorrowersPageSteps
import steps.CrmLoginPageSteps
import steps.EsMySqlDatabaseSteps
import steps.PersonalPageSteps
import steps.PrivateAreaLoginSteps

class BorrowerVerificationTest : BaseUITest() {

  private lateinit var tafDatabaseClient: TafDatabaseClient
  private lateinit var expectedUser: PersonalUserDataConfig
  private lateinit var actualUser: PersonalUserDataConfig

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

  fun `verify that data from Ui equals data from database`() {
    CrmLoginPageSteps().loginToCrm()
    val borrowerId: String? = BorrowersPageSteps().getBorrowerId()
    val dni: String = EsMySqlDatabaseSteps().getPassportNumber(borrowerId, tafDatabaseClient)
    actualUser.passportIdentificationNumber = dni
    clearCookie()
    PrivateAreaLoginSteps().loginToPrivateArea(actualUser, staticContext.smsCode)
    PersonalPageSteps().apply {
      expectedUser = getUserData()
    }
    EsMySqlDatabaseSteps().apply {
      val userAccountIdPersonalDataIdList: List<HashMap<String, Any>> =
        getUserDataById(borrowerId, tafDatabaseClient, selectUserAccountIdAndPersonalDataIdByBorrowerId)
      val userAccountId: String = getValueFromMap("user_account_id", userAccountIdPersonalDataIdList)
      val personalDataId: String = getValueFromMap("personal_data_id", userAccountIdPersonalDataIdList)
      val emailList = getUserDataById(userAccountId.toString(), tafDatabaseClient, selectUserEmailByUserAccountId)
      actualUser.email = getValueFromMap("email", emailList)
      val dniNameSurnameBirthdayList: List<HashMap<String, Any>> =
        getUserDataById(personalDataId.toString(), tafDatabaseClient, selectDniNameSurnameBirthdayByPersonalDataId)
      actualUser.passportIdentificationNumber = getValueFromMap("DNI", dniNameSurnameBirthdayList)
      actualUser.name = getValueFromMap("first_name", dniNameSurnameBirthdayList)
      actualUser.surname = getValueFromMap("first_last_name", dniNameSurnameBirthdayList)
      actualUser.dateOfBirth = getValueFromMap("birthday", dniNameSurnameBirthdayList)
      assertEquals(expectedUser, actualUser, "Expected user data doesn't match actual")
    }
  }
}
