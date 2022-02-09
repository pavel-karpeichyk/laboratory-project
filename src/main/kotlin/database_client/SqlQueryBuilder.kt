package database_client

import com.vladsch.kotlin.jdbc.SqlQuery

class SqlQueryBuilder {

  fun buildQuery(query: String, param: Map<String, Any>): SqlQuery {
    return SqlQuery(query, listOf(), param)
  }
}