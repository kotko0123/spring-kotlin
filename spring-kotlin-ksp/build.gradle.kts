//import org.springframework.boot.gradle.tasks.bundling.BootJar
//
//val jar: Jar by tasks
//val bootJar: BootJar by tasks
//
//bootJar.enabled = false
//jar.enabled = true
//
//dependencies {
//}

plugins {
  val kotlinVersion = "2.0.10"

  kotlin("jvm") version kotlinVersion
  id("com.google.devtools.ksp") version "2.0.10-1.0.24"
  `java-library`
}

dependencies {
  implementation("io.github.oshai:kotlin-logging-jvm:7.0.0")
  implementation("com.google.devtools.ksp:symbol-processing-api:2.0.10-1.0.24")
  // https://mvnrepository.com/artifact/com.squareup/kotlinpoet
  implementation("com.squareup:kotlinpoet:1.18.1")
}