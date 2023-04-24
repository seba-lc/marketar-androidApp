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
import com.sebastian.marketarv2.feature_products.presentation.products.ProductsScreen
import com.sebastian.marketarv2.feature_products.presentation.products.ProductsViewModel
import com.sebastian.marketarv2.feature_products.presentation.util.AppWrapper
import com.sebastian.marketarv2.feature_products.presentation.util.Screen
import com.sebastian.marketarv2.ui.theme.MarketarV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val productsViewModel = viewModel(modelClass = ProductsViewModel::class.java)

            MarketarV2Theme {
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ProductScreen.route
                    ) {
                        composable(route = Screen.ProductScreen.route) {
                            ProductsScreen(
                                viewModel = productsViewModel,
                                navController = navController
                            )
                        }
                    }
                }
            }

//
//            AppWrapper(
//                navController = navController,
//            ) {
//                NavHost(navController = navController, startDestination = Screen.MainScreen.route ) {
//                    composable(route = Screen.MainScreen.route) {
//                        ProductsScreen()
//                    }
//            }
//
//            }
        }
    }
}
