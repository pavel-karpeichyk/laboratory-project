package core.api.http

interface TafHTTPClient {

  fun getClient(): Any
  fun makeGetRequest(url: String): TafResponse
}