package com.avility.domain.model

data class SellerModel(
    val id: Int,
    val name: String,
    val reputation: ReputationLevel,
    val reputationName: String? = null
)

sealed class ReputationLevel(val color: Long, val code: String){
    data object Excellent : ReputationLevel(0xFF00a650, "5_green")
    data object Good : ReputationLevel(0xFF31E751, "4_light_green")
    data object Normal : ReputationLevel(0xfffff158, "3_yellow")
    data object Bad : ReputationLevel(0xFFFF7733, "2_orange")
    data object VeryBad : ReputationLevel(0xFFDD0808, "1_red")
    data object UnKnow : ReputationLevel(0xFFC5C3C3, "unknow")
}
