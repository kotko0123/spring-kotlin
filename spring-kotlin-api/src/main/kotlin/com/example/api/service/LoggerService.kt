package com.example.api.service

import com.example.ksp.AutoKLogger
import org.springframework.stereotype.Service

@AutoKLogger
@Service
class LoggerService {

  fun test() {
    logger.info { "test" }
  }
}