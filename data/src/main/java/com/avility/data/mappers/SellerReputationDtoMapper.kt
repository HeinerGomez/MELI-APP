package com.avility.data.mappers

import com.avility.data.remote.dto.SellerReputationDto
import com.avility.domain.model.ReputationLevel

fun SellerReputationDto.toModel(): ReputationLevel {
    return when(levelId) {
        ReputationLevel.Excellent.code -> ReputationLevel.Excellent
        ReputationLevel.Good.code -> ReputationLevel.Good
        ReputationLevel.Normal.code -> ReputationLevel.Normal
        ReputationLevel.Bad.code -> ReputationLevel.Bad
        ReputationLevel.VeryBad.code -> ReputationLevel.VeryBad
        else -> ReputationLevel.UnKnow
    }
}