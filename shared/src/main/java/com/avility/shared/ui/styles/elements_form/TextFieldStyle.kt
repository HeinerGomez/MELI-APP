package com.avility.shared.ui.styles.elements_form

import androidx.compose.ui.graphics.Color
import com.avility.shared.ui.constants.MeasureDimen
import com.avility.shared.ui.styles.DimensionParams

sealed class TextFieldStyle(
    open val dimensionParams: DimensionParams,
    open val containerColor: Color? = null,
    open val contentColor: Color? = null,
    open val fontSize: Float? = null
) {
    data object Standard : TextFieldStyle(
        dimensionParams = DimensionParams(
            height = MeasureDimen.DIMEN_X24.value
        ),
    )

    data class Custom(
        override val dimensionParams: DimensionParams,
        override val containerColor: Color,
        override val contentColor: Color,
        override val fontSize: Float? = null
    ) : TextFieldStyle(
        dimensionParams = dimensionParams,
        containerColor = containerColor,
        contentColor = contentColor,
        fontSize = fontSize
    )
}
