package core.driver.model

import core.driver.provider.BrowserType
import core.driver.provider.DriverType

data class DriverConfig(
  val driverType: DriverType,
  var browserType: BrowserType,
  val timeout: Long,
  val browserScreenSize: String,
  val hostRemoteDriver: String,
  val portRemoteDriver: String
)