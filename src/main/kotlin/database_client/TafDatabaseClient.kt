package database_client

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import core.context.databaseClientConfig

class TafDatabaseClient() : DatabaseClient {

  private lateinit var client: Session

  override fun getClient(): Session {
    client = with(databaseClientConfig) {
      session(url, user, pass)
    }
    return client
  }

  override fun selectOneRow(sqlQuery: String, param: Map<String, Any>): Map<String, Any> {
    val rowQuery: SqlQuery = SqlQueryBuilder().buildQueryWithParams(sqlQuery, param)
    return getClient().query(rowQuery, ResultSetProvider.getSingleRow)
  }

  override fun selectAllRows(sqlQuery: String, param: Map<String, Any>): List<HashMap<String, Any>> {
    val rowsQuery: SqlQuery = SqlQueryBuilder().buildQueryWithParams(sqlQuery, param)
    return getClient().query(rowsQuery, ResultSetProvider.getRows)
  }

  override fun closeDbConnection() {
    getClient().connection.close()
  }
}