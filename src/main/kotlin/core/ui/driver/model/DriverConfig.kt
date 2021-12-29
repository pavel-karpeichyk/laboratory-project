package core.ui.driver.model

import core.ui.driver.BrowserType
import core.ui.driver.DriverType

data class DriverConfig(
  val driverType: DriverType,
  var browserType: BrowserType,
  val timeout: Long,
  val browserScreenSize: String,
  val hostRemoteDriver: String,
  val portRemoteDriver: String
)