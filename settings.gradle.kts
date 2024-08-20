pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "spring-kotlin"
include("spring-kotlin-core")
include("spring-kotlin-api")
include("spring-kotlin-ksp")
