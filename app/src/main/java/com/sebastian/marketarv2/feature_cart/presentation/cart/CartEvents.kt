package com.sebastian.marketarv2.feature_cart.presentation.cart

sealed class CartEvents {
    object AddProduct : CartEvents()
    object SubstractProduct : CartEvents()
    object DeleteProduct : CartEvents()
    object DeleteCart : CartEvents()
}
