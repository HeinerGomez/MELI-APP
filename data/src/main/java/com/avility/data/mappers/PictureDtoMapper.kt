package com.avility.data.mappers

import com.avility.data.remote.dto.PictureDto
import com.avility.domain.model.PictureModel

fun PictureDto.toModel(): PictureModel = PictureModel(
    id = id,
    url = url
)