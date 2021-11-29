package core.driver.model

import core.driver.provider.BrowserType
import core.driver.provider.DriverType

data class DriverConfig(
  val driverType: DriverType,
  val browserType: BrowserType,
  val timeout: Long,
  val browserScreenSize: String,
  val hostRemoteDriver: String,
  val portRemoteDriver: String
)