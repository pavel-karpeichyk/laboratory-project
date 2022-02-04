package data_base

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery
import core.context.databaseClientConfig
import java.sql.ResultSet
import java.sql.ResultSetMetaData

class TafDatabaseClient() : DatabaseClient {

  private val client: Session = with(databaseClientConfig) {
    session(url, user, pass)
  }

  override fun getClient(): Session {
    return client
  }

  override fun selectOneRow(tableName: String, limitRows: String): Map<String, Any> {
    val rowQuery: SqlQuery = sqlQuery(SqlQueryBuilder().getLimitRows(tableName, limitRows))
    val getSingleRow: (ResultSet) -> Map<String, Any> = { resultSet ->
      val metaData: ResultSetMetaData = resultSet.metaData
      val row: HashMap<String, Any> = HashMap()
      while (resultSet.next()) {
        for (i in 1..metaData.columnCount) {
          row.put(metaData.getColumnName(i), resultSet.getObject(i))
        }
      }
      row
    }
    return client.query(rowQuery, getSingleRow)
  }

  override fun selectAllRows(tableName: String): List<HashMap<String, Any>> {
    val rowQuery: SqlQuery = sqlQuery(SqlQueryBuilder().getAllRows(tableName))
    val getRows: (ResultSet) -> List<HashMap<String, Any>> = { resultSet ->
      val metaData: ResultSetMetaData = resultSet.metaData
      val rows: ArrayList<HashMap<String, Any>> = ArrayList()
      while (resultSet.next()) {
        val row: HashMap<String, Any> = HashMap()
        for (i in 1..metaData.columnCount) {
          row.put(metaData.getColumnName(i), resultSet.getObject(i))
        }
        rows.add(row)
      }
      rows
    }
    return client.query(rowQuery, getRows)
  }

  override fun closeDbConnection() {
    client.connection.close()
  }
}