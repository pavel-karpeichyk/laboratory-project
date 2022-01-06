package core.mock

class Convertor {

   fun getResponseBodyToString(): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream("CrmSuccessLoginResponse.json")
      ?.readBytes()?.toString(Charsets.UTF_8)
  }
}