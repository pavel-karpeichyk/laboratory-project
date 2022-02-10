import database_client.EsMoneymanSqlQuery
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class CallDatabaseTest : BaseTest() {

  private lateinit var tafDatabaseClient: TafDatabaseClient

  @BeforeAll
  fun initClient() {
    tafDatabaseClient = TafDatabaseClient()
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDatabaseClient.closeDbConnection()
  }

  @Test
  fun `verify selectOneRow returns result from user account table for selected column`() {
    val actualValue: String = "admmin"
    val titleColumn: String = "login"
    val paramName: Map<String, Any> = mapOf("name" to "Master Testov")
    val userAccountByNameQuery: String = EsMoneymanSqlQuery.selectUserAccountByName
    val resultSingleRow: Map<String, Any> = tafDatabaseClient.selectOneRow(userAccountByNameQuery, paramName)
    val expectedValue: Any? = resultSingleRow[titleColumn]
    Assertions.assertEquals(expectedValue, actualValue, "Expected login doesn't match actual")
  }

  @Test
  fun `verify selectAllRows returns multiple results from user account table for selected email pattern`() {
    val regexEmail: Map<String, Any> = mapOf("email" to "ta%")
    val userAccountByRegexEmail: String = EsMoneymanSqlQuery.selectUserAccountByEmailRegex
    val resultRows: List<HashMap<String, Any>> = tafDatabaseClient.selectAllRows(userAccountByRegexEmail, regexEmail)
    Assertions.assertTrue(resultRows.size > 1, "List include one note or empty")
  }
}
