package com.avility.shared.ui

sealed class Screen(val route: String) {
    object ProductListScreen : Screen("product_list_screen")
    object DetailProductScreen : Screen("detail_product_screen")
}
