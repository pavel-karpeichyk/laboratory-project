package steps

import database_client.EsMoneymanSqlQuery.selectNameSurnameBirthdayByPersonalDataId
import database_client.EsMoneymanSqlQuery.selectUserAccountIdAndPersonalDataIdByBorrowerId
import database_client.EsMoneymanSqlQuery.selectUserEmailByUserAccountId
import database_client.EsMoneymanSqlQuery.selectUserPassportNumberByBorrowerId
import database_client.TafDatabaseClient

class EsMySqlDatabaseSteps(private val tafDatabaseClient: TafDatabaseClient = TafDatabaseClient()) {

  fun getUserPassportNumber(borrowerId: String): Map<String, Any> {
    val queryParams: Map<String, Any> = mapOf("id" to borrowerId)
    return tafDatabaseClient.selectOneRow(selectUserPassportNumberByBorrowerId, queryParams)
  }

  fun getUserAccountIdAndPersonalDataId(borrowerId: String): Map<String, Any> {
    val queryParams: Map<String, Any> = mapOf("id" to borrowerId)
    return tafDatabaseClient.selectOneRow(selectUserAccountIdAndPersonalDataIdByBorrowerId, queryParams)
  }

  fun getUserEmail(userAccountId: String): Map<String, Any> {
    val queryParams: Map<String, Any> = mapOf("id" to userAccountId)
    return tafDatabaseClient.selectOneRow(selectUserEmailByUserAccountId, queryParams)
  }

  fun getUserNameSurnameBirthday(personalDataId: String): Map<String, Any> {
    val queryParams: Map<String, Any> = mapOf("id" to personalDataId)
    return tafDatabaseClient.selectOneRow(selectNameSurnameBirthdayByPersonalDataId, queryParams)
  }
}