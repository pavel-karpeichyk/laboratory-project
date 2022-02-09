package database_client

import com.vladsch.kotlin.jdbc.SqlQuery

class SqlQueryBuilder {

  fun buildQueryWithParams(query: String, param: Map<String, Any>): SqlQuery {
    return SqlQuery(query).params(param)
  }

  fun buildQueryWithoutParams(query: String): SqlQuery {
    return SqlQuery(query)
  }
}