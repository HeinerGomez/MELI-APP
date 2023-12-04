package com.avility.domain.model

data class ProductModel (
    val id: String,
    val title: String,
    val price: Int,
    val availableQuantity: Int,
    val condition: ConditionProduct,
    val thumbnail: String
)

sealed class ConditionProduct(val code: String, val value: String) {
    object New : ConditionProduct("new", "Nuevo")
    object Used : ConditionProduct("used", "Usado")
}