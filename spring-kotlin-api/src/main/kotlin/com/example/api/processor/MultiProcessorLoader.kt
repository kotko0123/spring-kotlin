package com.example.api.processor

import org.springframework.stereotype.Component

@Component
class MultiProcessorLoader(
    private val processors: Map<String, MultiProcessor>
) {
    fun getProcessor(beanName: String): MultiProcessor {
        return processors[beanName] ?: throw IllegalArgumentException("Unknown processor: $beanName")
    }

    fun loadAllProcessor(a: Int, b: Int) {
        processors.values.forEach {
            it.process(a, b)
        }
    }
}
