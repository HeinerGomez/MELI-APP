package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class SellerReputationDto(
    @Json(name = "level_id")
    val levelId: String? = null,
    @Json(name = "power_seller_status")
    val powerSellerStatus: String? = null
)
