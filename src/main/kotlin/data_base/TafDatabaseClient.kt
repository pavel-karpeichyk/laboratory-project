package data_base

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

  override fun selectOneRow(sqlQuery: SqlQuery, limit: Int): Map<String, Any> {
    val rowQuery: SqlQuery = SqlQueryBuilder().getLimitRows(sqlQuery, limit)
    return client.query(rowQuery, ResultSetProvider.getSingleRow)
  }

  override fun selectAllRows(sqlQuery: SqlQuery): List<HashMap<String, Any>> {
    val rowsQuery: SqlQuery = SqlQueryBuilder().getAllRows(sqlQuery)
    return client.query(rowsQuery, ResultSetProvider.getRows)
  }

  override fun closeDbConnection() {
    client.connection.close()
  }
}