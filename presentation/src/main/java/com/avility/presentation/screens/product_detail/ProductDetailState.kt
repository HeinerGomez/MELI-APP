package com.avility.presentation.screens.product_detail

import androidx.annotation.StringRes
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.SellerModel

/**
 * [ProductDetailState] data class to represent the state of detail of product
 *
 * @author Heiner Gómez
 * @param [isLoading] to know if the data is fetching
 * @param [product] to represent the detail of product data
 * @param [seller] to represent the seller data
 * @param [errorMessage] to represent any error that can happened
 */
data class ProductDetailState(
    val isLoading: Boolean = false,
    val product: DetailProductModel? = null,
    val seller: SellerModel? = null,
    @StringRes val errorMessage: Int? = null
)