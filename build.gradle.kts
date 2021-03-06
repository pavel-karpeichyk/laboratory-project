import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val junitJupiter: String by project
val junitJupiterApi: String by project
val junitJupiterParams: String by project
val jacksonModuleKotlin: String by project
val jacksonDataFormatYaml: String by project
val log4jApi: String by project
val log4jCore: String by project
val selenideVersion: String by project
val slf4jLog4j12: String by project
val commonsIo: String by project
val okHttp: String by project
val loggingInterceptor: String by project
val retrofitVersion: String by project
val converterGsonVersion: String by project
val wiremockVersion: String by project
val allureVersion: String by project
val jdbcVersion: String by project
val mysqlConnectorVersion: String by project

plugins {
  kotlin("jvm") version "1.6.10"
  idea
  id("io.qameta.allure") version "2.9.6"
}

apply(plugin = "org.jetbrains.kotlin.jvm")
apply(plugin = "io.qameta.allure")

idea {
  project {
    jdkName = "1.8"
    languageLevel = IdeaLanguageLevel("1.8")
  }
  module.name = "LaboratoryProject"
}



group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
  mavenLocal()
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation("org.junit.jupiter:junit-jupiter:$junitJupiter")
  testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterApi")
  testImplementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterParams")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlin")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonDataFormatYaml")
  implementation("org.apache.logging.log4j:log4j-api:$log4jApi")
  implementation("org.apache.logging.log4j:log4j-core:$log4jCore")
  implementation("com.codeborne:selenide:$selenideVersion")
  testImplementation("org.slf4j:slf4j-log4j12:$slf4jLog4j12")
  implementation("commons-io:commons-io:$commonsIo")
  implementation("com.squareup.okhttp3:okhttp:$okHttp")
  implementation("com.squareup.okhttp3:logging-interceptor:$loggingInterceptor")
  implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
  implementation("com.squareup.retrofit2:converter-gson:$converterGsonVersion")
  implementation("com.github.tomakehurst:wiremock:$wiremockVersion")
  implementation ("com.vladsch.kotlin-jdbc:kotlin-jdbc:$jdbcVersion")
  implementation ("mysql:mysql-connector-java:$mysqlConnectorVersion")
}

allure {
  adapter.autoconfigure
  adapter.aspectjWeaver
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}