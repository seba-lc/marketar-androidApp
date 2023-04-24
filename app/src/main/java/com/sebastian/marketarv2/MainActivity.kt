package com.sebastian.marketarv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sebastian.marketarv2.feature_products.presentation.products.ProductsScreen
import com.sebastian.marketarv2.feature_products.presentation.products.ProductsViewModel
import com.sebastian.marketarv2.ui.theme.MarketarV2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            println("LLEGOOO ACAAAAA")
            val productScreenViewModel = viewModel(modelClass = ProductsViewModel::class.java)
            val products by productScreenViewModel.state.collectAsState()
            println("NOOOOO LLEGOOO ACAAAAA")

            MarketarV2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProductsScreen(products)
                }
            }
        }
    }
}
