package com.avility.data.mappers

import com.avility.data.remote.dto.ProductDto
import com.avility.domain.model.ConditionProduct
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