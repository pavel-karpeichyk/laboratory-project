package database_client

import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.sqlQuery

class SqlQueryBuilder {

  fun buildQueryWithParams(query: String, param: Map<String, Any>?): SqlQuery {
    if (param != null) {
      return sqlQuery(query, param)
    }
    return sqlQuery(query)
  }
}