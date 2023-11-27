package com.avility.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.avility.shared.ui.components.containers.MainContainer
import com.avility.shared.ui.components.elements_form.StandardTextField
import com.avility.shared.ui.constants.MeasureDimen
import com.avility.shared.ui.styles.elements_form.TextFieldStyle

@Composable
fun ProductListScreen(
    navController: NavController
) {
    MainContainer(
        isLoading = true,
        header = {
            StandardTextField(
                style = TextFieldStyle.Standard,
                placeholder = "Encuentra lo que buscabas ...",
            )
        }
    ) {
        Text(text = "Hola MELI")
    }
}