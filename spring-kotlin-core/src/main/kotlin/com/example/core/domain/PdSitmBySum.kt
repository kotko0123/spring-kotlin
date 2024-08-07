package com.example.core.domain

import jakarta.persistence.*

@Entity
class PdSitmBySum(

    @Id
    @Column(name = "sitm_no")
    var sitmNo: String,

    @Column(name = "vld_od_cnt")
    var buyCount: Long
)
