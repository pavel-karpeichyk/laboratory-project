package core.convecters

enum class MonthType(val index: String) {
  ENERO("01"),
  FEBRERO("02"),
  MARZO("03"),
  ABRIL("04"),
  MAYO("05"),
  JUNIO("06"),
  JULIO("07"),
  AGOSTO("08"),
  SEPTIEMBRE("09"),
  OCTUBRE("10"),
  NOVIEMBRE("11"),
  DICIEMBRE("12");
}

fun main(){
  var string = "octubre"
  for(month in MonthType.values()){
    if(string.uppercase() == month.name){
      string=month.index
    }

  }

  println(string)
}