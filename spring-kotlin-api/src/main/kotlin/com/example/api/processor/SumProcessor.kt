package com.example.api.processor

import com.example.core.log.logger
import org.springframework.stereotype.Component

@Component(value = "sumProcessor")
class SumProcessor : MultiProcessor {
    override fun process(a: Int, b: Int) {
        val value = a + b
        logger.info("SumProcessor: $a + $b = $value")
    }
}
