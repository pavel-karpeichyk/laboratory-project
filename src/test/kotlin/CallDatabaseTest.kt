import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.sqlQuery
import data_base.SqlQueryBuilder
import data_base.TafDatabaseClient
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class CallDatabaseTest : BaseTest() {

  private val actualValue: String = "admmin"
  private val titleColumn: String = "login"
  private val limitRows: Int = 1
  private val query : SqlQuery = sqlQuery("SELECT * FROM es_moneyman.user_account LIMIT ?")
  private lateinit var tafDataBaseClient: TafDatabaseClient

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
    val resultSingleRow = tafDataBaseClient.selectOneRow(query, limitRows)
    val expectedValue = resultSingleRow[titleColumn]
    Assertions.assertEquals(expectedValue, actualValue, "Expected login doesn't match actual")
  }
}
