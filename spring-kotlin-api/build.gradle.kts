import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = true

plugins {
    id("com.google.devtools.ksp") version "2.0.10-1.0.24"
}

dependencies {
    implementation(project(":spring-kotlin-core"))
    implementation(project(":spring-kotlin-ksp"))
    ksp(project(":spring-kotlin-ksp"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
}
