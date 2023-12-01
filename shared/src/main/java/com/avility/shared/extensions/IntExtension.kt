package com.avility.shared.extensions

import java.text.NumberFormat
import java.util.Locale

fun Int.toCurrency(): String {
    val formatCOP: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
    return formatCOP.format(this)
}