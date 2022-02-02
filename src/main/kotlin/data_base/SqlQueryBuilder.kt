package data_base

class SqlQueryBuilder {
  fun getLimitRows(limitRows: String = "1",tableName: String = "es_moneyman.user_account"): String {
    return "SELECT * FROM $tableName limit $limitRows"
  }
  fun getAllRows(tableName: String = "es_moneyman.user_account"): String {
    return "SELECT * FROM $tableName"
  }
}