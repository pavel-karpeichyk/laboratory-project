package core.mock.config

class WireMockHeader {

  private var headerWithAuthToken: Map<String, String> = mapOf()

  fun getHeaderWithAuthToken(): Map<String, String> {
    var cookieTitle: String = "Set-Cookie"
    var cookieValue: String = "AuthUser=eyJhbGciOiJIUzUxMiJ" +
        ".eyJleHRyYSI6eyJyZWdpc3RyYXRpb25JZCI6Im9sZC11c2VyLWE4NWRlODJjLWVhN2EtMTFlOS1hZTI5LTAwNTA1NmI3OGNmOSJ9LCJtZXRhZGF0YSI6eyJ1c2VySWQiOjEsInBlcm1pc3Npb25zIjp7IlN1cGVyQWRtaW4iOltdfX0sImlhdCI6MTY0MDg1MTE0Niwic3ViIjoiYWRtbWluIn0.3C9TVqKIzHNI50-B2L7WJl6zSvdzGN_la6LmOPhg4m65OY4ALsq8CFf-iFXTB3RlJEbeWb-cQ-kI13iqFikJ6Q; Path=/; Expires=Fri, 31 Dec 2021 07:59:06 GMT;"
    return mapOf(cookieTitle to cookieValue).also { headerWithAuthToken = it }
  }
}