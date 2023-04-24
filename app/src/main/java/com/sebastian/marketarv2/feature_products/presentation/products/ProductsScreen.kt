package com.sebastian.marketarv2.feature_products.presentation.products

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductsScreen(
    state: ProductsState
) {
//    val state by viewModel.state
//    val scope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(state.products) {product ->
            Text(text = product.productName + "..... $" + product.price)
        }

    }

}