package com.example.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

//@EnableJpaRepositories(basePackages = ["com.example.core.domain"])
@SpringBootApplication(scanBasePackages = ["com.example"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
