package com.avility.presentation.screens.product_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.avility.presentation.R
import com.avility.shared.R as SharedResource
import com.avility.presentation.components.ProductItem
import com.avility.shared.ui.Screen
import com.avility.shared.ui.components.containers.MainContainer
import com.avility.shared.ui.components.elements_form.SearchTextField
import com.avility.shared.ui.components.others.LottieInfoScreen
import com.avility.shared.ui.styles.elements_form.TextFieldStyle

@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.value
    val keyboardController = LocalSoftwareKeyboardController.current

    MainContainer(
        isLoading = viewModel.uiState.value.isLoading,
        header = {
            SearchTextField(
                style = TextFieldStyle.Standard,
                placeholder = stringResource(R.string.search_field_placeholder),
                value = state.querySearch,
                onTextChange = { value ->
                    viewModel.dispatchAction(ProductListAction.UpdateQueryValue(value))
                },
                onSearch = {
                    keyboardController?.hide()
                    viewModel.dispatchAction(ProductListAction.Search)
                },
                onClearSearch = {
                    keyboardController?.show()
                    viewModel.dispatchAction(ProductListAction.UpdateQueryValue(""))
                }
            )
        }
    ) {
        if (state.data.isNotEmpty()) {
            LazyColumn {
                items(state.data) { product ->
                    ProductItem(product) {
                        navController.navigate(Screen.DetailProductScreen.route + "/${product.id}")
                    }
                    HorizontalDivider()
                }
            }
        }

        state.data.ifEmpty {
            if (!state.isLoading) {
                state.errorMessage?.let {
                    LottieInfoScreen(
                        resource = SharedResource.raw.error_alert,
                        message = stringResource(it),
                        contentColor = MaterialTheme.colorScheme.tertiary
                    )
                } ?: LottieInfoScreen(
                    resource = SharedResource.raw.empty_search,
                    message = stringResource(R.string.search_field_placeholder),
                    contentColor = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}