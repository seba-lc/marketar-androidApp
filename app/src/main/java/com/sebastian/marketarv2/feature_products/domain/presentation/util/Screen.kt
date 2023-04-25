package com.sebastian.marketarv2.feature_products.domain.presentation.util

sealed class Screen(val route: String) {
    object ProductScreen : Screen("products")
    object LandingScreen : Screen("landing")
    object MainScreen : Screen("main")
    object CheckoutScreen : Screen("checkout")
}
