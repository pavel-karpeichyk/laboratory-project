package core.convecters

class FileConverter {

  fun getResponseBodyToString(fileName: String): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)
      ?.readBytes()?.toString(Charsets.UTF_8)
  }
}