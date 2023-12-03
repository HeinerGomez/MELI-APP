package com.avility.data.mappers

import com.avility.data.remote.dto.ProductDto
import com.avility.domain.model.ConditionProduct
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.ProductModel

fun ProductDto.toModel(): ProductModel = ProductModel(
    id = id,
    title = title,
    price = price,
    availableQuantity = availableQuantity,
    condition = if (condition == ConditionProduct.New.code) {
        ConditionProduct.New
    } else {
        ConditionProduct.Used
    },
    thumbnail = thumbnail
)

fun ProductDto.toDetailModel(): DetailProductModel = DetailProductModel(
    id = id,
    sellerId = sellerId,
    title = title,
    price = price,
    condition = if (condition == ConditionProduct.New.code) {
         ConditionProduct.New
    } else {
        ConditionProduct.Used
    },
    soldQuantity = soldQuantity ?: 0,
    pictures = pictures?.map { it.toModel() } ?: emptyList(),
    availableQuantity = initialQuantity ?: 0,
    attributes = attributes?.map { it.toModel() } ?: emptyList(),
    sellerLocation = sellerAddress?.toModel()
)