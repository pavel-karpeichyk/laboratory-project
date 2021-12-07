package core.HTTP

class StringParser {

  fun getValueFromCookie(str: String): String {
    var value = ""
    var parts = str.split(";")
    var userAuth = parts[0].split("=")
    if (userAuth[0].equals("AuthUser")) {
      value = userAuth[1]
    }
    return value
  }
}