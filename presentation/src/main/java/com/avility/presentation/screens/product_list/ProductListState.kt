package com.avility.presentation.screens.product_list

import androidx.annotation.StringRes
import com.avility.domain.model.ProductModel

data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductModel> = emptyList(),
    val querySearch: String = "",
    @StringRes val errorMessage: Int? = null
)