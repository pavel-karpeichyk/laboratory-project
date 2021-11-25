package task_1064.driver.factory

import task_1064.driver.config.DataDriverProvider

interface DriverFactory {

    fun setDriverConfig(dataDriverConfig: DataDriverProvider)
}