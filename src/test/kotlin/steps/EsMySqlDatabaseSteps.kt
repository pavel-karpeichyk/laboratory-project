package steps

import database_client.EsMoneymanSqlQuery
import database_client.TafDatabaseClient

class EsMySqlDatabaseSteps {

  fun getPassportNumber(id: String?, client: TafDatabaseClient): String {
    val paramId: Map<String, Any> = mapOf("id" to "$id")
    val query: String = EsMoneymanSqlQuery.selectUserPassportNumberByBorrowerId
    val result: Map<String, Any> = client.selectOneRow(query, paramId)
    return result["DNI"].toString()
  }

  fun getUserDataById(id: String?, client: TafDatabaseClient, query: String): List<HashMap<String, Any>> {
    val paramId: Map<String, Any> = mapOf("id" to "$id")
    return client.selectAllRows(query, paramId)
  }

  fun getValueFromMap(key: String, data: List<HashMap<String, Any>>): String {
    var value: Any? = null
    for (d in data) {
      value = d[key]
    }
    return value.toString()
  }
}