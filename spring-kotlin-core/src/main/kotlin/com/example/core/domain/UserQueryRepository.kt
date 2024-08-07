package com.example.core.domain

import com.example.core.domain.QUser.*
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserQueryRepository(
  private val jpaQueryFactory: JPAQueryFactory
) {

  fun getUsersByName(name: String?): List<User> {
    return jpaQueryFactory
      .selectFrom(user)
      .where(eqName(name))
      .fetch()
  }

  fun eqName(name: String?): BooleanExpression? {
    if (name.isNullOrEmpty()) {
      return null
    }
    return user.name.eq(name)
  }
}