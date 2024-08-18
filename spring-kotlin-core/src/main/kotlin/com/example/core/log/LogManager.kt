package com.example.core.log

import io.github.oshai.kotlinlogging.KotlinLogging
import org.slf4j.LoggerFactory

// singleton
object LogManager {
  inline fun <reified T:Any> logger() = LoggerFactory.getLogger(T::class.java)!!

  inline fun <reified T : Any> kLogger() = KotlinLogging.logger(T::class.java.name)
}
