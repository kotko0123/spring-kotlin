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

  fun eqId(id: Long): BooleanExpression? {
    return when (id) {
      null, 0L -> null
      else -> user.id.eq(id)
    }
  }

  fun eqName(name: String?): BooleanExpression? = name?.let { user.name.eq(name) }
  /*if (name == null) null else user.name.eq(name)*/
}