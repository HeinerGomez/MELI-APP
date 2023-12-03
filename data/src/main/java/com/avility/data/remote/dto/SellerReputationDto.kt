package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class SellerReputationDto(
    @field:Json(name = "level_id")
    val levelId: String? = null,
    @field:Json(name = "power_seller_status")
    val powerSellerStatus: String? = null
)
