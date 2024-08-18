package com.example.core.log

import io.github.oshai.kotlinlogging.KotlinLogging

val logger = KotlinLogging.logger {}

// 공통 로거를 생성하는 유틸리티 클래스
class LoggerDelegate<in R : Any>(private val clazz: R) {
  val logger = KotlinLogging.logger(clazz::class.java.name)
}

// 확장 함수를 통해 쉽게 로거를 사용하도록 함
inline fun <reified T : Any> T.logger() = LoggerDelegate(this).logger
