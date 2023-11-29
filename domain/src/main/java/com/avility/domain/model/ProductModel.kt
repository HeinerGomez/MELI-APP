package com.avility.domain.model

data class ProductModel (
    val id: String,
    val title: String,
    val price: Int,
    val availableQuantity: Int,
    val condition: String,
    val thumbnail: String
)