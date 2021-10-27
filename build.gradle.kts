import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
  kotlin("jvm") version "1.5.31"
  idea
}

idea {
  project {
    jdkName = "1.8"
    languageLevel = IdeaLanguageLevel("1.8")
  }
  module.name = "KotlinFramework"
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.1")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")
}

tasks.test {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}