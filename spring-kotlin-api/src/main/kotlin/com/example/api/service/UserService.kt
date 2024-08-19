package com.example.api.service

import com.example.core.domain.User
import com.example.core.domain.UserQueryRepository
import com.example.core.log.logger
import org.springframework.stereotype.Service

@Service
class UserService(
  private val userQueryRepository: UserQueryRepository
) {

  fun getUsersByName(name: String?): List<User> {
    val users = userQueryRepository.getUsersByName(name)
    logger.info { "users: $users" }
    return users
  }
}