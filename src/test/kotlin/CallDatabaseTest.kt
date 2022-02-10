import database_client.EsMoneymanSqlQuery
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class CallDatabaseTest : BaseTest() {

  private val actualValue: String = "admmin"
  private val titleColumn: String = "login"
  private lateinit var tafDatabaseClient: TafDatabaseClient
  private val paramName: Map<String, Any> = mapOf("name" to "Master Testov")
  private val userAccountByNameQuery: String = EsMoneymanSqlQuery.selectUserAccountByName
  private val regexEmail: Map<String, Any> = mapOf("email" to "ta%")
  private val userAccountByRegexEmail: String = EsMoneymanSqlQuery.selectEmailUserAccountByRegex

  @BeforeAll
  fun initClient() {
    tafDatabaseClient = TafDatabaseClient()
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDatabaseClient.closeDbConnection()
  }

  @Test
  fun `verify login in data that gets from database`() {
    val resultSingleRow: Map<String, Any> = tafDatabaseClient.selectOneRow(userAccountByNameQuery, paramName)
    val expectedValue: Any? = resultSingleRow[titleColumn]
    Assertions.assertEquals(expectedValue, actualValue, "Expected login doesn't match actual")
  }

  @Test
  fun `verify emails `() {
    val resultRows: List<HashMap<String, Any>> = tafDatabaseClient.selectAllRows(userAccountByRegexEmail, regexEmail)
    Assertions.assertTrue(resultRows.size > 1, "List include one note or empty")
  }
}
