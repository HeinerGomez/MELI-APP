package com.avility.shared.ui.components.elements_form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.avility.shared.ui.constants.MeasureDimen
import com.avility.shared.ui.constants.roundedShapes
import com.avility.shared.ui.styles.elements_form.TextFieldStyle

@Composable
fun StandardTextField(
    style: TextFieldStyle,
    placeholder: String = "",
    value: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: (value: String) -> Unit = {}
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(style.dimensionParams.height)
            .padding(MeasureDimen.DIMEN_X00.value),
        value = value,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.colors(
            focusedTextColor = style.contentColor ?: MaterialTheme.colorScheme.onPrimaryContainer,
            focusedContainerColor = style.containerColor ?: MaterialTheme.colorScheme.primaryContainer,
            unfocusedContainerColor = style.containerColor ?: MaterialTheme.colorScheme.primaryContainer,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        textStyle = MaterialTheme.typography.labelSmall.run {
            style.fontSize?.let {
                copy(fontSize = TextUnit(it, TextUnitType.Sp))
            } ?: this
        },
        placeholder = {
            Text(
                text = placeholder,
                color = style.contentColor ?: MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.labelSmall.run {
                    style.fontSize?.let {
                        copy(fontSize = TextUnit(it, TextUnitType.Sp))
                    } ?: this
                }
            )
        },
        isError = false,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        singleLine = true,
        shape = roundedShapes.large
    )
}

@Composable
@Preview(showBackground = true)
fun StandardTextFieldPreview() {
    StandardTextField(
        style = TextFieldStyle.Standard,
        placeholder = "Encuentra lo que buscabas ...",
        value = "ALGO"
    )
}