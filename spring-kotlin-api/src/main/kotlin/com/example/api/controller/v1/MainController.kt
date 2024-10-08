package com.example.api.controller.v1

import com.example.api.processor.MultiProcessorLoader
import com.example.api.service.TestService
import com.example.api.service.UserService
import com.example.core.domain.PdSitmBySum
import com.example.core.domain.PdSitmBySumRepository
import com.example.core.domain.User
import com.example.core.log.logger
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder

@Transactional
@RestController
@RequestMapping("/")
class MainController(
  private val pdSitmBySumRepository: PdSitmBySumRepository,
  private val processorLoader: MultiProcessorLoader,
  private val testService: TestService,
  private val userService: UserService
) {

  @GetMapping
  fun get(): String {
    logger.info { "hello world" }
    val list = pdSitmBySumRepository.findTop100ByOrderByBuyCountDesc()
    list.forEach {
      logger.warn { "${it.buyCount} - ${it.sitmNo}" }
    }

    val range = (1..10000000)
    pdSitmBySumRepository.save(PdSitmBySum("sitmNo_${range.random()}", range.random().toLong()))

    val stringBuilder = StringBuilder()
    val all = pdSitmBySumRepository.getAll()
    all.forEach {
      logger.info { "${it.buyCount} - ${it.sitmNo}" }
      stringBuilder.append("${it.buyCount} - ${it.sitmNo}\n")
    }
    return stringBuilder.toString()
  }

  @GetMapping("/test")
  fun test(): String {
    return testService.test()
  }

  @GetMapping("/users")
  fun users(): List<User> {
    return userService.getUsersByName("kim")
  }

  @GetMapping("/processor/{processorName}")
  fun processor(@PathVariable processorName: String): String {
    processorLoader.getProcessor(processorName).process(1, 2)
    return "success - $processorName"
  }

  @GetMapping("/processor/all")
  fun processor(): String {
    processorLoader.loadAllProcessor( 1, 2)
    return "success - all"
  }
}