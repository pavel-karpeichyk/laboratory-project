package data_base

class SqlQueryBuilder {

  private val queryLimitRows: String = "SELECT * FROM %s LIMIT %s"
  private val queryAllRows: String = "SELECT * FROM %s "

  fun getLimitRows(tableName: String, limitRows: String): String {
    return queryLimitRows.format(tableName, limitRows)
  }

  fun getAllRows(tableName: String): String {
    return queryAllRows.format(tableName)
  }
}