package database_client

object EsMoneymanSqlQuery {
  private const val schema: String = "es_moneyman"

  val selectUserAccountByName: String = """
    SELECT * FROM $schema.user_account WHERE name = :name
    """.trimIndent()

  val selectUserAccountByEmailRegex: String = """
    SELECT * FROM $schema.user_account WHERE email LIKE :email
  """.trimIndent()

  val selectUserPassportNumberByBorrowerId: String = """
   SELECT $schema.mm_aes_decrypt(personal_data.passport_identification_number) 
   AS "DNI"
   FROM $schema.borrower 
   JOIN $schema.personal_data on borrower.personal_data_id = personal_data.id
   WHERE borrower.id = :id
 """.trimIndent()
}