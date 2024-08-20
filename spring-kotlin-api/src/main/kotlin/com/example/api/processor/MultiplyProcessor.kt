package com.example.api.processor

import com.example.core.log.LogManager
import com.example.core.log.logger
import org.springframework.stereotype.Component

@Component(value = "multiplyProcessor")
class MultiplyProcessor : MultiProcessor {
  companion object {
    private val log = LogManager.logger<MultiplyProcessor>()
    private val kLogger = LogManager.kLogger<SumProcessor>()
    private val logger = logger()
  }

  override fun process(a: Int, b: Int) {
    val value = a * b
    logger.info { "MultiplyProcessor: $a * $b = $value" }
    try {
      if (value == 3) throw RuntimeException("test error!!!")
    } catch (e: Exception) {
      logger.error(e) { "logger $value" }
      log.error("log $value", e)
      kLogger.error(e) { "kLogger $value" }
    }

    log.info("MultiplyProcessor(log): $value")
    logger.info { "MultiplyProcessor(kLogger): $a * $b = $value" }
  }
}
