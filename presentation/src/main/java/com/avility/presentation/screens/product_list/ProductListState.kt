package com.avility.presentation.screens.product_list

import com.avility.domain.model.ProductModel

data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductModel> = emptyList(),
    val querySearch: String = "",
    val errorMessage: String? = null
)