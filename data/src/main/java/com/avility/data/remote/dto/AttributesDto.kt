package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class AttributesDto (
    val id: String,
    val name: String,
    @field:Json(name = "value_name")
    val valueName: String? = null
)