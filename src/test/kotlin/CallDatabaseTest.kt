import com.vladsch.kotlin.jdbc.Session
import core.context.databaseClientConfig
import data_base.TafDatabaseClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CallDatabaseTest : BaseTest() {

  private val tafDataBaseClient: TafDatabaseClient = TafDatabaseClient()
  private val actualValue = "admmin"

  @Test
  fun `verify login in data that gets from database`() {
    val client: Session = tafDataBaseClient.getClient(
      databaseClientConfig.url,
      databaseClientConfig.user,
      databaseClientConfig.pass
    )
    val resultSingleRow: Map<String, Any> = tafDataBaseClient.selectOneRow(client)
    val expectedValue = resultSingleRow["login"]
    Assertions.assertEquals(expectedValue, actualValue, "Expected login doesn't match actual")
  }
}
