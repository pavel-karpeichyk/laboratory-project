package data_base

import com.vladsch.kotlin.jdbc.SqlQuery

class SqlQueryBuilder {

  fun getLimitRows(sqlQuery: SqlQuery, limitRows: Int): SqlQuery {
    return sqlQuery.params(limitRows)
  }

  fun getAllRows(sqlQuery: SqlQuery): SqlQuery {
    return sqlQuery
  }
}