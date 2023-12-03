package com.avility.presentation.screens.product_detail

import androidx.annotation.StringRes
import com.avility.domain.model.DetailProductModel
import com.avility.domain.model.SellerModel

data class ProductDetailState(
    val isLoading: Boolean = false,
    val product: DetailProductModel? = null,
    val seller: SellerModel? = null,
    @StringRes val errorMessage: Int? = null
)