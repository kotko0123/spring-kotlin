package com.example.core.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PdSitmBySumRepository : JpaRepository<PdSitmBySum, String>, PdSitmBySumRepositoryCustom {
    fun findTop100ByOrderByBuyCountDesc(): List<PdSitmBySum>
}
