package core.api.HTTPclient

interface TafHTTPClient {

  fun getClient(): Any
  fun makeGetRequest(url: String): TafResponse
}