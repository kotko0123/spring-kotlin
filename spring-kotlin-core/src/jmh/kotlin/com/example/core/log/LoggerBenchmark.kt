package com.example.core.log

import io.github.oshai.kotlinlogging.KotlinLogging
import org.openjdk.jmh.annotations.*
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@Fork(value = 1, jvmArgs= {"-Xms4G", "-Xmx4G"})
open class LoggerBenchmark {

  // 방법 1: logger() 확장 함수 사용
  private val logger1 = logger()

  // 방법 2: LogManager.logger<SumProcessor>() 사용
  private val logger2 = LogManager.logger<LoggerBenchmark>()

  // 방법 3: LogManager.kLogger<SumProcessor>() 사용
  private val logger3 = LogManager.kLogger<LoggerBenchmark>()

  // 방법 4: companion object에서 logger() 확장 함수 사용
  companion object {
    private val logger4 = logger()
  }

  // 방법 5: KotlinLogging.logger(SumProcessor::class.java.name) 사용
  private val logger5 = KotlinLogging.logger(LoggerBenchmark::class.java.name)

  @Benchmark
  fun method1() {
    logger1.info { "Testing method 1" }
  }

  @Benchmark
  fun method2() {
    logger2.info("Testing method 2")
  }

  @Benchmark
  fun method3() {
    logger3.info { "Testing method 3" }
  }

  @Benchmark
  fun method4() {
    logger4.info { "Testing method 4" }
  }

  @Benchmark
  fun method5() {
    logger5.info { "Testing method 5" }
  }
}
