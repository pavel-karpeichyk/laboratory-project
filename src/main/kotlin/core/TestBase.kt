package core

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.Before
import org.junit.BeforeClass
import org.junit.jupiter.api.BeforeAll
import org.junit.runners.Parameterized

open class TestBase {


    @BeforeAll
    fun setup() {
      Configuration.browser = "chrome"
      Configuration.timeout = 10000

      Selenide.open("https://www.google.by")
    }
  }
