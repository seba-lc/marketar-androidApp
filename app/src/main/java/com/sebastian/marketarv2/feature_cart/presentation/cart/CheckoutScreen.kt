package com.sebastian.marketarv2.feature_cart.presentation.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.sebastian.marketarv2.feature_products.domain.presentation.products.ProductsViewModel

@Composable
fun CheckoutScreen(
    viewModel: CartViewModel,
    productsViewModel: ProductsViewModel
) {
    val state by viewModel.state
    val productsState by productsViewModel.state.collectAsState()

    var totalPrice = 0.0
    viewModel.state.value.products.forEach { product ->
        totalPrice += product.quantity * product.price
    }


    Column {
        LazyColumn {
            items(state.products) { item ->

                val productItem =
                    productsState.products.find { product -> product.productName == item.productName }
                val painter = rememberImagePainter(
                    data = "https://storage.googleapis.com/marketar_bucket/" + item.image,
                    builder = {
                        crossfade(true)
                    }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                        ) {
                            Image(
                                painter = painter,
                                contentDescription = item.productName,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .padding(4.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = "${item.productName}: ${item.quantity}/${item.unit}",
                        )
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "$${item.price * item.quantity}")
                        Spacer(modifier = Modifier.width(5.dp))
                        IconButton(
                            onClick = {
                                if (productItem != null) {
                                    viewModel.onEvent(CartEvents.DeleteProduct, productItem)
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete item",
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "TOTAL: $${totalPrice}",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                textDecoration = TextDecoration.Underline
            )
        )
        if (state.products.size != 0) {
            Button(
                onClick = {
                    //Acá quiero generar el POST a mi API
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Proceder Al pago")
            }
        }

    }


}