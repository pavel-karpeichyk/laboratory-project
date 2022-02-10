package database_client

object EsMoneymanSqlQuery {
  private const val schema: String = "es_moneyman"

  val selectUserAccountByName: String = """
    SELECT * FROM $schema.user_account WHERE name = :name
    """.trimIndent()

  val selectEmailUserAccountByRegex: String = """
    SELECT * FROM $schema.user_account WHERE email LIKE :email
  """.trimIndent()
}