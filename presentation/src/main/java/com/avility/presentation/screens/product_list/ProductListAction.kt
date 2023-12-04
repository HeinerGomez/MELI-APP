package com.avility.presentation.screens.product_list

sealed class ProductListAction {
    data class UpdateQueryValue(val query: String) : ProductListAction()

    object Search : ProductListAction()
}
