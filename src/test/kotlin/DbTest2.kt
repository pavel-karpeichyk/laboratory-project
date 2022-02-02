import com.sun.org.apache.xpath.internal.operations.Bool
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery
import org.junit.jupiter.api.Test
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.SQLException

class DbTest2 {

  @Test
  fun `check connection with DB`(): Unit {
    val session = session(
      "jdbc:mysql://mmes-master.idfaws.com:3306?characterEncoding=UTF-8&useSSL=false",
      "root",
      "root"
    )
    println("DB -> OK!!")
   // session.connection.close()
  //println(session.connection.isClosed)

    val allIdsQuery: SqlQuery = sqlQuery("select * from es_moneyman.user_account limit 5")

    val getSingleRow: (ResultSet) -> List<HashMap<String, Any>> = { resultSet ->
      val md: ResultSetMetaData = resultSet.metaData
      val countRow: Int = resultSet.row
      val count: Int = md.columnCount
      val row: HashMap<String, Any> = HashMap<String, Any>()
      val rows: ArrayList<HashMap<String, Any>> = ArrayList<HashMap<String, Any>>()
      while (resultSet.next()) {
        for (i in 1..count) {
          row.put(md.getColumnName(i), resultSet.getObject(i))
          rows.add(row)
        }
      }

      rows
    }

    val resultSets: List<HashMap<String, Any>> = session.query(allIdsQuery, getSingleRow)
    println(resultSets)
    println("SIZE ->${resultSets.size}")
  }
}
