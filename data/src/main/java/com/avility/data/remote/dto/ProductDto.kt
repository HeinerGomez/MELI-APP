package com.avility.data.remote.dto

import com.squareup.moshi.Json

data class ProductDto(
    val id: String,
    val title: String,
    val price: Int,
    @Json(name = "available_quantity")
    val availableQuantity: Int,
    val condition: String,
    val thumbnail: String,
    @Json(name = "sold_quantity")
    val soldQuantity: Int? = null,
    val pictures: List<PictureDto>? = null,
    val attributes: List<AttributesDto>? = null,
    @Json(name = "seller_id")
    val sellerId: Int? = null,
    @Json(name = "seller_address")
    val sellerAddress: SellerAddressDto? = null
)