package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class ProductDto(
    val id: String,
    val title: String,
    val price: Int,
    @field:Json(name = "available_quantity")
    val availableQuantity: Int,
    @field:Json(name = "initial_quantity")
    val initialQuantity: Int? = null,
    val condition: String,
    val thumbnail: String,
    @field:Json(name = "sold_quantity")
    val soldQuantity: Int? = null,
    val pictures: List<PictureDto>? = null,
    val attributes: List<AttributesDto>? = null,
    @field:Json(name = "seller_id")
    val sellerId: Long? = null,
    @field:Json(name = "seller_address")
    val sellerAddress: SellerAddressDto? = null
)