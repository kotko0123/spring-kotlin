package com.example.core.log

import io.github.oshai.kotlinlogging.KotlinLogging
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@State(Scope.Benchmark)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 5, jvmArgs= ["-Xms2G", "-Xmx2G"])
open class LoggerBenchmark {

  companion object {
    // 방법 2: LogManager.logger<SumProcessor>() 사용
    private val logger2 = LogManager.logger<LoggerBenchmark>()
    // 방법 3: LogManager.kLogger<SumProcessor>() 사용
    private val logger3 = LogManager.kLogger<LoggerBenchmark>()
    // 방법 4: companion object에서 logger() 확장 함수 사용
    private val logger4 = logger()
    // 방법 5: KotlinLogging.logger(SumProcessor::class.java.name) 사용
    private val logger5 = KotlinLogging.logger(LoggerBenchmark::class.java.name)
  }

  // 방법 1: logger global 함수 사용
  @Benchmark
  fun method1(bh: Blackhole) {
    bh.consume(logger.info { "Testing method 1" })
  }

  @Benchmark
  fun method2(bh: Blackhole) {
    bh.consume(logger2.info("Testing method 2"))
  }

  @Benchmark
  fun method3(bh: Blackhole) {
    bh.consume(logger3.info { "Testing method 3" })
  }

  @Benchmark
  fun method4(bh: Blackhole) {
    bh.consume(logger4.info { "Testing method 4" })
  }

  @Benchmark
  fun method5(bh: Blackhole) {
    bh.consume(logger5.info { "Testing method 5" })
  }
}
