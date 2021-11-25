package task_1064.driver.model

data class DriverConfig(
  val driverType: String,
  val browserType: String,
  val timeout: Long,
  val browserScreenSize: String,
  val hostRemoteDriver: String,
  val portRemoteDriver: String
)