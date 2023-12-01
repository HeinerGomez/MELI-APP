package com.avility.meli.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.avility.presentation.screens.product_detail.ProductDetailScreen
import com.avility.presentation.screens.product_list.ProductListScreen
import com.avility.shared.ui.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ProductListScreen.route
    ) {
        composable(Screen.ProductListScreen.route) {
            ProductListScreen(navController)
        }
        composable(Screen.DetailProductScreen.route) {
            ProductDetailScreen()
        }
    }
}