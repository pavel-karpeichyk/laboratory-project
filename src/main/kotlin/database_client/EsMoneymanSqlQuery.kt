package database_client

object EsMoneymanSqlQuery {
  val selectAllFromUserAccountByName: String = """SELECT * FROM es_moneyman.user_account WHERE name = :name"""
    .trimIndent()
  val selectAllFromUserAccountByLimitRows: String = """SELECT * FROM es_moneyman.user_account limit = :limit"""
    .trimIndent()
}