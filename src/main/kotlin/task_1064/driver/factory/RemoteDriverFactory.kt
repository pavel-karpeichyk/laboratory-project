package task_1064.driver.factory

import com.codeborne.selenide.Configuration
import io.github.bonigarcia.wdm.WebDriverManager
import task_1064.driver.config.DataDriverConfig
import task_1064.driver.model.DriverConfigModel

class RemoteDriverFactory() : DriverFactory {

  private val driveModel: DriverConfigModel = DataDriverConfig().getConfig()

  override fun getContent(dataDriverConfig: DataDriverConfig) {
    Configuration.remote = "${driveModel.hostRemoteDriver}:${driveModel.portRemoteDriver}"
    Configuration.browser = driveModel.browserType
    Configuration.timeout = driveModel.timeout!!.toLong()
    Configuration.browserSize = driveModel.browserScreenSize
    WebDriverManager.getInstance().setup()
  }
}