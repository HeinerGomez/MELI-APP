package com.avility.data.mappers

import com.avility.data.remote.dto.SellerAddressDto
import com.avility.domain.model.BasicLocationModel

fun SellerAddressDto.toModel(): BasicLocationModel = BasicLocationModel(
    country = country.name,
    city = city.name
)