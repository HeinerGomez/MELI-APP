package com.avility.presentation.screens.product_list

import androidx.annotation.StringRes
import com.avility.domain.model.ProductModel

/**
 * [ProductListState] data class to represent the state of products
 *
 * @author Heiner Gómez
 * @param [isLoading] to know if the data is fetching
 * @param [data] to represent the products data
 * @param [querySearch] to represent the query value that user typed in the search field
 * @param [errorMessage] to represent any error that can happened
 */
data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductModel> = emptyList(),
    val querySearch: String = "",
    @StringRes val errorMessage: Int? = null
)