package task_1064.driver.factory

import task_1064.driver.config.DataDriverConfig

interface DriverFactory {

    fun getContent(dataDriverConfig: DataDriverConfig)
}