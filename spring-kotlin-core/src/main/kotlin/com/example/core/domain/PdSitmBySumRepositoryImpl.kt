package com.example.core.domain

import com.querydsl.jpa.impl.JPAQueryFactory

class PdSitmBySumRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : PdSitmBySumRepositoryCustom {

    override fun getAll(): List<PdSitmBySum> {
        return jpaQueryFactory
            .selectFrom(QPdSitmBySum.pdSitmBySum)
            .fetch()
    }

}
