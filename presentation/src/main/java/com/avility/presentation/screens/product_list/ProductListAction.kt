package com.avility.presentation.screens.product_list

/**
 * [ProductListAction] to represent the actions that configure the behaviour of the view
 *
 * @author Heiner Gómez
 */
sealed class ProductListAction {
    data class UpdateQueryValue(val query: String) : ProductListAction()

    object Search : ProductListAction()
}
