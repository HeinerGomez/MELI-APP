package com.avility.domain.model

data class DetailProductModel(
    val id: String,
    val sellerId: Int,
    val title: String,
    val price: Int,
    val condition: String,
    val soldQuantity: Int,
    val pictures: List<PictureModel>,
    val availableQuantity: Int,
    val attributes: List<AttributeModel>,
    val sellerLocation: BasicLocationModel
)