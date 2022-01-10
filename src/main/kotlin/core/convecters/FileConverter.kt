package core.convecters

class FileConverter {

   fun getResponseBodyToString(): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream("CrmSuccessLoginResponse.json")
      ?.readBytes()?.toString(Charsets.UTF_8)
  }
}