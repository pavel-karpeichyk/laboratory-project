package data_base

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery

interface DatabaseClient {

  fun getClient(): Session
  fun selectOneRow(sqlQuery: SqlQuery, limit:Int): Map<String, Any>
  fun selectAllRows(sqlQuery: SqlQuery): List<HashMap<String, Any>>
  fun closeDbConnection()
}