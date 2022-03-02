package steps

import database_client.TafDatabaseClient

class EsMySqlDatabaseSteps {

  fun getUserDataById(id: String?, client: TafDatabaseClient, query: String): MutableMap<String, Any> {
    val paramId: Map<String, Any> = mapOf("id" to "$id")
    return client.selectOneRow(query, paramId).toMutableMap()
  }

  fun getValueFromMap(key: String, map : Map<String, Any>) : String{
    return map[key].toString()
  }
}