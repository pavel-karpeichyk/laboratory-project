package task_1064.driver.model

data class DriverConfigModel(
  val driverType: String? = null,
  val browserType: String? = null,
  val timeout: String? = null,
  val browserScreenSize: String? = null,
  val hostRemoteDriver: String? = null,
  val portRemoteDriver: String? = null
)