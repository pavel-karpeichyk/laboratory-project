package steps

import database_client.EsMoneymanSqlQuery
import database_client.TafDatabaseClient

class EsMySqlDatabaseSteps {

  fun getPassportNumber(id: String?, client: TafDatabaseClient) : String {

    val paramId: Map<String, Any> = mapOf("id" to "$id")
    val query = EsMoneymanSqlQuery.selectUserPassportNumberByBorrowerId
    val result = client.selectOneRow(query, paramId)
   return result["DNI"].toString()
  }
}