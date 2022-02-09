import database_client.EsMoneymanSqlQuery
import database_client.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class CallDatabaseTest : BaseTest() {

  private val actualValue: String = "admmin"
  private val titleColumn: String = "login"
  private lateinit var tafDataBaseClient: TafDatabaseClient
  private val param: Map<String, Any> = mapOf("name" to "Master Testov")
  private val sqlQuery: String = EsMoneymanSqlQuery.selectAllFromUserAccountByName

  @BeforeAll
  fun initClient() {
    tafDataBaseClient = TafDatabaseClient()
  }

  @AfterAll
  fun closeDatabaseConnection() {
    tafDataBaseClient.closeDbConnection()
  }

  @Test
  fun `verify login in data that gets from database`() {
    val resultSingleRow : Map<String, Any> = tafDataBaseClient.selectOneRow(sqlQuery, param)
    val expectedValue: Any? = resultSingleRow[titleColumn]
    Assertions.assertEquals(expectedValue, actualValue, "Expected login doesn't match actual")
  }
}
