package com.example.core.log

import io.github.oshai.kotlinlogging.KotlinLogging
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.springframework.boot.test.context.SpringBootTest
import kotlin.system.measureTimeMillis


@SpringBootTest
class LoggerPerformanceTest {

  companion object {
    private const val ITERATIONS = 1_000_000
  }

  // 방법 1: logger() 확장 함수 사용
  private val logger1 = logger()

  // 방법 2: LogManager.logger<SumProcessor>() 사용
  private val logger2: Logger = LogManager.logger<LoggerPerformanceTest>()

  // 방법 3: LogManager.kLogger<SumProcessor>() 사용
  private val logger3 = LogManager.kLogger<LoggerPerformanceTest>()

  // 방법 4: companion object에서 logger() 확장 함수 사용
  private val logger4 = logger()

  // 방법 5: KotlinLogging.logger(SumProcessor::class.java.name) 사용
  private val logger5 = KotlinLogging.logger(LoggerPerformanceTest::class.java.name)

  @Test
  fun testLogger1Performance() {
    val time = measureTimeMillis {
      repeat(ITERATIONS) {
        logger1.info { "Testing method 1" }
      }
    }
    println("Method 1 (logger() 확장 함수) took $time ms")
  }

  @Test
  fun testLogger2Performance() {
    val time = measureTimeMillis {
      repeat(ITERATIONS) {
        logger2.info("Testing method 2")
      }
    }
    println("Method 2 (LogManager.logger<SumProcessor>()) took $time ms")
  }

  @Test
  fun testLogger3Performance() {
    val time = measureTimeMillis {
      repeat(ITERATIONS) {
        logger3.info { "Testing method 3" }
      }
    }
    println("Method 3 (LogManager.kLogger<SumProcessor>()) took $time ms")
  }

  @Test
  fun testLogger4Performance() {
    val time = measureTimeMillis {
      repeat(ITERATIONS) {
        logger4.info { "Testing method 4" }
      }
    }
    println("Method 4 (companion object에서 logger()) took $time ms")
  }

  @Test
  fun testLogger5Performance() {
    val time = measureTimeMillis {
      repeat(ITERATIONS) {
        logger5.info { "Testing method 5" }
      }
    }
    println("Method 5 (KotlinLogging.logger(class name)) took $time ms")
  }
}