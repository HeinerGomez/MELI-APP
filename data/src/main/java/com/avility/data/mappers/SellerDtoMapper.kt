package com.avility.data.mappers

import com.avility.data.remote.dto.SellerDto
import com.avility.domain.model.SellerModel

fun SellerDto.toModel(): SellerModel = SellerModel(
    id = id,
    name = nickname,
    reputation = reputation.toModel(),
    reputationName = reputation.powerSellerStatus
)