package data_base

import com.vladsch.kotlin.jdbc.Session

interface DatabaseClient {

  fun getClient(urlDB : String, user: String, pass: String) : Session
  fun selectOneRow(client: Session): Map<String, Any>
  fun selectAllRows(client : Session): List<HashMap<String, Any>>
  fun closeDbConnection( client: Session)
}