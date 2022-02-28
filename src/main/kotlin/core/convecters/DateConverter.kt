package core.convecters

class DateConverter {

  fun getMonthAsNumber(month: String): String {
    var index: String = month
    for (monthType in MonthType.values()) {
      if (month.uppercase() == monthType.name) {
        index = monthType.index
      }
    }
    return index
  }

  fun convertDayFormat(day: String): String {
    var day = day
    if (day.length == 1) {
      day = "0$day"
    }
    return day
  }
}