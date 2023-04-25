package com.sebastian.marketarv2.feature_cart.presentation.cart

import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct

data class CartState(
    val products: MutableList<CartProduct> = mutableListOf<CartProduct>()
)
