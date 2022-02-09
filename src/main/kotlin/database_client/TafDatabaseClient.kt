package database_client

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import core.context.databaseClientConfig

class TafDatabaseClient() : DatabaseClient {

  private val client: Session = with(databaseClientConfig) {
    session(url, user, pass)
  }

  override fun getClient(): Session {
    return client
  }

  override fun selectOneRow(sqlQuery: String, param: Map<String, Any>): Map<String, Any> {
    val rowQuery: SqlQuery = SqlQueryBuilder().buildQuery(sqlQuery, param)
    return client.query(rowQuery, ResultSetProvider.getSingleRow)
  }

  override fun selectAllRows(sqlQuery: String, param: Map<String, Any>): List<HashMap<String, Any>> {
    val rowsQuery: SqlQuery = SqlQueryBuilder().buildQuery(sqlQuery, param)
    return client.query(rowsQuery, ResultSetProvider.getRows)
  }

  override fun closeDbConnection() {
    client.connection.close()
  }
}