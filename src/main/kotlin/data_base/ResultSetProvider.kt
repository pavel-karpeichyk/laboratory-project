package data_base

import java.sql.ResultSet
import java.sql.ResultSetMetaData

object ResultSetProvider {

  val getSingleRow: (ResultSet) -> Map<String, Any> = { resultSet ->
    val metaData: ResultSetMetaData = resultSet.metaData
    val row: HashMap<String, Any> = HashMap()
    while (resultSet.next()) {
      for (i in 1..metaData.columnCount) {
        row.put(metaData.getColumnName(i), resultSet.getObject(i))
      }
    }
    row
  }

  val getRows: (ResultSet) -> List<HashMap<String, Any>> = { resultSet ->
    val metaData: ResultSetMetaData = resultSet.metaData
    val rows: ArrayList<HashMap<String, Any>> = ArrayList()
    while (resultSet.next()) {
      val row: HashMap<String, Any> = HashMap()
      for (i in 1..metaData.columnCount) {
        row.put(metaData.getColumnName(i), resultSet.getObject(i))
      }
      rows.add(row)
    }
    rows
  }
}