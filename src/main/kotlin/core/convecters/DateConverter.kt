package core.convecters

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateConverter {

  fun getMonthAsNumber(month: String): String {
    return MonthType.valueOf(month.uppercase()).index
  }

  fun getDateInSelectedFormat(
    actualDate: String,
    actualDateFormat: String,
    expectedDateFormat: String
  ): String {
    val actualDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(actualDateFormat)
    val expectedDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(expectedDateFormat)
    return LocalDate.parse(actualDate, actualDateFormatter).atStartOfDay().format(expectedDateFormatter)
  }
}