import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.configureFor
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import core.api.crm.controller.CrmController
import core.api.crm.service.CrmAuthService
import core.http.client.LocalHttpClient
import core.http.response.TafResponse
import core.http.retrofit.RetrofitClient
import core.mock.WireMockBuilder
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import steps.RegistrationPageSteps
import java.io.InputStream
import java.util.*

class WireMockTest:BaseTest() {

  private var expectedUserTokenCookieName: String = "AuthUser"


  @Test
  fun `get on wire mock server and use it `() {
    val wireMockClient = WireMock("localhost", 8080)

    val mappingBuilder = WireMock.post(WireMock.urlEqualTo("/secure/rest/sign/in")).
    willReturn(aResponse().withBody(WireMockBuilder().getResponseBodyToString()).withStatus(291))
    wireMockClient.register(mappingBuilder)
    val service: CrmAuthService = RetrofitClient.getRetrofitClient("http://127.0.0.1:8080").create(CrmAuthService::class.java)

      val response: TafResponse = CrmController().authCrm()
  }
}