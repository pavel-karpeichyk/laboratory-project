package data_base

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery
import java.sql.ResultSet
import java.sql.ResultSetMetaData

class TafDatabaseClient : DatabaseClient {

  override fun getClient(urlDB: String, user: String, pass: String): Session {
    return session(urlDB, user, pass)
  }

  override fun selectOneRow(client: Session): Map<String, Any> {
    val rowQuery: SqlQuery = sqlQuery(SqlQueryBuilder().getLimitRows())
    val getSingleRow: (ResultSet) -> Map<String, Any> = { resultSet ->
      val metaData: ResultSetMetaData = resultSet.metaData
      val row: HashMap<String, Any> = HashMap<String, Any>()
      while (resultSet.next()) {
        for (i in 1..metaData.columnCount) {
          row.put(metaData.getColumnName(i), resultSet.getObject(i))
        }
      }
      row
    }
    return client.query(rowQuery, getSingleRow)
  }

  override fun selectAllRows(client: Session): List<HashMap<String, Any>> {
    val rowQuery: SqlQuery = sqlQuery(SqlQueryBuilder().getAllRows())
    val getRows: (ResultSet) -> List<HashMap<String, Any>> = { resultSet ->
      val metaData: ResultSetMetaData = resultSet.metaData
      val row: HashMap<String, Any> = HashMap<String, Any>()
      val rows: ArrayList<HashMap<String, Any>> = ArrayList<HashMap<String, Any>>()
      while (resultSet.next()) {
        for (i in 1..metaData.columnCount) {
          row.put(metaData.getColumnName(i), resultSet.getObject(i))
          rows.add(row)
        }
      }
      rows
    }
    return client.query(rowQuery, getRows)
  }

  override fun closeDbConnection(client: Session) {
    client.connection.close()
  }
}