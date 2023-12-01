package com.avility.shared.ui.components.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.avility.shared.ui.components.elements_form.SearchTextField
import com.avility.shared.ui.components.others.LottieProgressBar
import com.avility.shared.ui.constants.MeasureSmallDimen
import com.avility.shared.ui.styles.elements_form.TextFieldStyle

@Composable
fun MainContainer(
    isLoading: Boolean,
    header: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            header?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MeasureSmallDimen.DIMEN_X50.value)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(MeasureSmallDimen.DIMEN_X10.value),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    it()
                }
            }
            Spacer(Modifier.height(MeasureSmallDimen.DIMEN_X04.value))
            Box(modifier = Modifier.padding(MeasureSmallDimen.DIMEN_X10.value)) {
                content()
            }
        }
        if (isLoading) {
            LottieProgressBar()
        }
    }
}

@Composable
@Preview(
    device = Devices.PIXEL_3A,
    showBackground = true,
    backgroundColor = 0xFFFEF69D
)
fun MainContainerPreview() {
    MainContainer(
        isLoading = true,
        header = {
            SearchTextField(
                style = TextFieldStyle.Standard,
                placeholder = "Buscar algo ...",
            )
        }
    ) {
        Text(text = "Hola MELI!")
    }
}