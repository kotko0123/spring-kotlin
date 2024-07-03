import org.springframework.boot.gradle.tasks.bundling.BootJar

val bootJar: BootJar by tasks
bootJar.enabled = true


dependencies {
    implementation(project(":spring-kotlin-core"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
}
