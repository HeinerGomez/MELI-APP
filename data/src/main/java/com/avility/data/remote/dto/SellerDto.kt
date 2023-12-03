package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class SellerDto(
    val id: Int,
    val nickname: String,
    @field:Json(name = "seller_reputation")
    val reputation: SellerReputationDto
)
