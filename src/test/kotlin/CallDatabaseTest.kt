import data_base.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class CallDatabaseTest : BaseTest() {

  private val actualValue: String = "admmin"
  private val titleColumn: String = "login"
  private val tableName: String = "es_moneyman.user_account"
  private val limitRows: String = "1"
  private lateinit var tafDataBaseClient: TafDatabaseClient

  @BeforeAll
  fun initClient() {
    tafDataBaseClient = TafDatabaseClient()
  }

  @AfterAll
  fun closeDatabase() {
    tafDataBaseClient.closeDbConnection()
  }

  @Test
  fun `verify login in data that gets from database`() {
    val resultSingleRow = tafDataBaseClient.selectOneRow(tableName, limitRows)
    val expectedValue = resultSingleRow[titleColumn]
    Assertions.assertEquals(expectedValue, actualValue, "Expected login doesn't match actual")
  }
}
