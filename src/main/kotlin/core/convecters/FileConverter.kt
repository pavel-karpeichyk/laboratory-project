package core.convecters

class FileConverter {

  fun getResponseBodyAsString(filePath: String): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(filePath)
      ?.readBytes()?.toString(Charsets.UTF_8)
  }
}