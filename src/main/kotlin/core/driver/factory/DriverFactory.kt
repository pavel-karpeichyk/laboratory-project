package core.driver.factory

import core.driver.model.DriverConfig

interface DriverFactory {

    fun setDriverConfig(driveModel: DriverConfig)
}