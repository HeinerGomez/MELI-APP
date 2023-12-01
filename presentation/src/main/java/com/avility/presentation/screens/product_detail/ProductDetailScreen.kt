package com.avility.presentation.screens.product_detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.avility.presentation.R
import com.avility.shared.R as SharedResource
import com.avility.shared.ui.components.containers.MainContainer
import com.avility.shared.ui.components.others.LottieEmptyScreen

@Composable
fun ProductDetailScreen() {
    MainContainer(
        isLoading = false,
        header = null
    ) {
        LottieEmptyScreen(
            resource = SharedResource.raw.empty_search,
            message = stringResource(R.string.search_field_placeholder)
        )
    }
}