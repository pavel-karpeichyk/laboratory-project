package database_client

object EsMoneymanSqlQuery {
  private const val schema: String = "es_moneyman"

  val selectAllFromUserAccountByName: String = """
    SELECT * FROM $schema.user_account WHERE name = :name
    """.trimIndent()

  val selectAllFromUserAccountByLimitRows: String = """
    SELECT * FROM $schema.user_account limit = :limit
    """.trimIndent()
}