package com.avility.data.mappers

import com.avility.data.remote.dto.AttributesDto
import com.avility.domain.model.AttributeModel

fun AttributesDto.toModel(): AttributeModel = AttributeModel(
    id = id,
    title = name,
    value = valueName.orEmpty()
)