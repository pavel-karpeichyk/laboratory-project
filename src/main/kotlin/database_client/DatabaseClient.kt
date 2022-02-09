package database_client

import com.vladsch.kotlin.jdbc.Session

interface DatabaseClient {

  fun getClient(): Session
  fun selectOneRow(sqlQuery: String,param : Map<String, Any>): Map<String, Any>
  fun selectAllRows(sqlQuery: String, param :Map<String, Any>): List<HashMap<String, Any>>
  fun closeDbConnection()
}