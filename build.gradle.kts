import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
  kotlin("jvm") version "1.5.31"
  idea
  id("io.qameta.allure") version "2.9.6"
}

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

  implementation("org.junit.jupiter:junit-jupiter:5.7.0")
  implementation("org.testng:testng:7.1.0")
 // testImplementation("au.com.dius.pact.provider:gradle:4.2.14")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")
  implementation("org.apache.logging.log4j:log4j-api:2.14.1")
  implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
  implementation("pl.pragmatists:JUnitParams:1.1.1")
  implementation("ru.yandex.qatools.htmlelements:htmlelements-java:1.20.0")
  implementation("net.lightbody.bmp:browsermob-proxy:2.0-beta-8")
  testImplementation("org.testng:testng:6.14.3")
  implementation("junit:junit:4.13.1")
  implementation("org.apache.httpcomponents:httpclient:4.3.4")

  implementation("com.codeborne:selenide:6.0.3")
  testImplementation("org.slf4j:slf4j-log4j12:1.6.6")
  implementation("commons-io:commons-io:2.11.0")

}


tasks.test {
  useJUnitPlatform()

}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}