package com.avility.presentation.screens.productList

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.avility.shared.ui.components.containers.MainContainer
import com.avility.shared.ui.components.elements_form.StandardTextField
import com.avility.shared.ui.styles.elements_form.TextFieldStyle

@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel()
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