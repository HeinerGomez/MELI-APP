package com.avility.domain.model

data class SellerModel(
    val id: Int,
    val name: String,
    val reputation: ReputationLevel
)

sealed class ReputationLevel(val color: Long){
    data object Excellent : ReputationLevel(0xFF00a650)
    data object Good : ReputationLevel(0xFF31E751)
    data object Normal : ReputationLevel(0xfffff158)
    data object Bad : ReputationLevel(0xFFFF7733)
    data object VeryBad : ReputationLevel(0xFFDD0808)
    data object UnKnow : ReputationLevel(0xFFC5C3C3)
}
