package com.example.core.domain

import jakarta.persistence.*

@Entity(name = "pd_sitm_by_sum")
class PdSitmBySum(

    @Id
    @Column(name = "sitm_no")
    var sitmNo: String,

    @Column(name = "vld_od_cnt")
    var buyCount: Long
) {
    constructor() : this(sitmNo = "", buyCount = 0)
}
