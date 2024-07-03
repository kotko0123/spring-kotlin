package com.example.core.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    fun mainHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    fun mainDataSource(@Qualifier("mainHikariConfig") hikariConfig: HikariConfig): HikariDataSource {
        return HikariDataSource(hikariConfig)
    }
}
