package com.sebastian.marketarv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sebastian.marketarv2.feature_cart.presentation.cart.CartViewModel
import com.sebastian.marketarv2.feature_cart.presentation.cart.CheckoutScreen
import com.sebastian.marketarv2.feature_products.domain.presentation.products.ProductsScreen
import com.sebastian.marketarv2.feature_products.domain.presentation.products.ProductsViewModel
import com.sebastian.marketarv2.feature_products.presentation.util.AppWrapper
import com.sebastian.marketarv2.feature_products.domain.presentation.util.Screen
import com.sebastian.marketarv2.ui.theme.MarketarV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val productsViewModel = viewModel(modelClass = ProductsViewModel::class.java)
            val cartViewModel = viewModel(modelClass = CartViewModel::class.java)

            val navController = rememberNavController()

            MarketarV2Theme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    AppWrapper(navController = navController) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.ProductScreen.route
                        ) {
                            composable(route = Screen.ProductScreen.route) {
                                ProductsScreen(
                                    viewModel = productsViewModel,
                                    cartViewModel = cartViewModel,
                                    navController = navController
                                )
                            }
                            composable(route = Screen.CheckoutScreen.route) {
                                CheckoutScreen(viewModel = cartViewModel, productsViewModel = productsViewModel)
                            }
                        }
                    }
                }
            }

        }
    }
}
