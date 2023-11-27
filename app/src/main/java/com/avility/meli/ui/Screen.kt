package com.avility.meli.ui

sealed class Screen(val route: String) {
    data object ProductListScreen : Screen("product_list_screen")
    data object DetailProductScreen : Screen("detail_product_screen")
}
