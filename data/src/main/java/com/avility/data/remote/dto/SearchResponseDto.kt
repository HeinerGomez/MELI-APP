package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class SearchResponseDto (
    val results: List<ProductDto>,
    @Json(name = "site_id")
    val siteId: String,
)