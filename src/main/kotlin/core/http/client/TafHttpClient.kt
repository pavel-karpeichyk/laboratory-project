package core.http.client

import core.http.response.TafResponse

interface TafHttpClient {

  fun getClient(): Any
  fun makeGetRequest(url: String): TafResponse
}