package core.ui.driver.factory

import core.ui.driver.model.DriverConfig

interface DriverFactory {

  fun setDriverConfig(driverModel: DriverConfig)
}