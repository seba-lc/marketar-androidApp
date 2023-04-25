package com.sebastian.marketarv2.feature_products.domain.presentation.products

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sebastian.marketarv2.feature_cart.presentation.cart.CartViewModel
import com.sebastian.marketarv2.feature_products.domain.model.Product
import com.sebastian.marketarv2.feature_products.domain.presentation.products.components.ProductCard

@Composable
fun ProductsScreen(
    viewModel: ProductsViewModel,
    cartViewModel: CartViewModel,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(state.products) {product ->
            ProductCard(
                item = product,
                viewModel = cartViewModel
            )
        }

    }

}