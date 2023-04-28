package com.sebastian.marketarv2.feature_products.presentation.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sebastian.marketarv2.feature_cart.presentation.cart.CartViewModel
import com.sebastian.marketarv2.feature_products.domain.model.Product
import com.sebastian.marketarv2.feature_products.presentation.products.components.ProductCard
import com.sebastian.marketarv2.feature_products.presentation.util.Screen

@Composable
fun ProductsScreen(
    viewModel: ProductsViewModel,
    cartViewModel: CartViewModel,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    val scope = rememberCoroutineScope()

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(state.products) { product ->
            ProductCard(
                item = product,
                viewModel = cartViewModel
            )
        }

    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 2100f
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        if (cartViewModel.state.value.products.size != 0) {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.CheckoutScreen.route)
                },
                backgroundColor = MaterialTheme.colors.background,
                modifier = Modifier
                    .padding(20.dp),
            ) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Carrito (${cartViewModel.state.value.products.size})")
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Go to Checkout"
                    )
                }
            }
        }
    }
}