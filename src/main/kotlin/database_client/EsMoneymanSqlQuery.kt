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

  val selectUserAccountIdAndPersonalDataIdByBorrowerId: String = """
  SELECT user_account_id, personal_data_id
   FROM $schema.borrower
   WHERE $schema.borrower.id = :id
  """.trimIndent()

  val selectUserEmailByUserAccountId: String = """
  SELECT email 
  FROM $schema.user_account 
  WHERE id = :id
  """.trimIndent()

  val selectDniNameSurnameBirthdayByPersonalDataId: String = """
  SELECT $schema.mm_aes_decrypt(personal_data.passport_identification_number) 
   AS "DNI",
  first_name,
  first_last_name,
  birthday
  FROM $schema.personal_data 
  WHERE id = :id
  """.trimIndent()
}