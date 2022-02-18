import core.ui.driver.setter.DriverConfigSetter
import core.ui.elements.Browser.clearCookie
import core.ui.elements.Browser.verifyCurrentUrl
import core.ui.pages.PersonalPage
import database_client.EsMoneymanSqlQuery
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import steps.BorrowersPageSteps
import steps.PersonalPageSteps
import steps.PrivateAreaLoginSteps

class VerifyDataTest : BaseTest() {
  private lateinit var tafDatabaseClient: TafDatabaseClient
  private val columnTitle: String = "es_moneyman.mm_aes_decrypt(personal_data.passport_identification_number)"
  private val loanDetailUrl = "https://mmes-master.idfaws.com/client-area/#/loan-detail"

  @BeforeAll
  fun initClient() {
    tafDatabaseClient = TafDatabaseClient()
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDatabaseClient.closeDbConnection()
  }

  @Test
  fun `verify that data from Ui equals data from database`() {
    DriverConfigSetter().setDriverConfig()
    val id = BorrowersPageSteps().getIdBorrower()
    val paramId: Map<String, Any> = mapOf("id" to "$id")
    val query = EsMoneymanSqlQuery.selectUserPassportNumberByBorrowerId
    val result = tafDatabaseClient.selectOneRow(query, paramId)
    val dni: String = result[columnTitle].toString()
    clearCookie()
    PrivateAreaLoginSteps().privateAreaLogin(dni)
    verifyCurrentUrl(loanDetailUrl)
    with(PersonalPageSteps()){
      openPersonalPage()
      verifyCurrentUrl(getPersonalPageUrl())
    }
    println(PersonalPage().getName())
    println(PersonalPage().getSurname())
    println(PersonalPage().getPassportNumber())
    println(PersonalPage().getEmail())

  }
}
