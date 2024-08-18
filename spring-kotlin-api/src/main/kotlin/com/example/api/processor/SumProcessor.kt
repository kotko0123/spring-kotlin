package com.example.api.processor

import com.example.core.log.LogManager
import com.example.core.log.logger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component

@Component(value = "sumProcessor")
class SumProcessor : MultiProcessor {
    companion object {
        private val log = LogManager.logger<SumProcessor>()
        private val kLogger = LogManager.kLogger<SumProcessor>()
        private val logger2 = logger()
        private val logger3 = KotlinLogging.logger(SumProcessor::class.java.name)
    }
    override fun process(a: Int, b: Int) {
        val value = a + b
        logger.info { "SumProcessor: $a + $b = $value" }

        log.info("SumProcessor(log): $value")

        kLogger.info { "SumProcessor(kLogger): $a + $b = $value" }

        logger2.info { "SumProcessor(logger2): $a + $b = $value" }

        logger3.info { "SumProcessor(logger3): $a + $b = $value" }
    }
}
