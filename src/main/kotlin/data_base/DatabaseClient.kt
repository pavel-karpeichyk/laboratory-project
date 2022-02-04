package data_base

import com.vladsch.kotlin.jdbc.Session

interface DatabaseClient {

  fun getClient(): Session
  fun selectOneRow(tableName: String, limitRows: String): Map<String, Any>
  fun selectAllRows(tableName: String): List<HashMap<String, Any>>
  fun closeDbConnection()
}