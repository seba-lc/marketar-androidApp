package com.sebastian.marketarv2.feature_cart.presentation.cart

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun CheckoutScreen(
    viewModel: CartViewModel
) {
    val state by viewModel.state


    LazyColumn {
        items(state.products) { item ->
            Text(text = item.productName + ".... qt: " + item.quantity + " " + item.unit)
        }
    }


}