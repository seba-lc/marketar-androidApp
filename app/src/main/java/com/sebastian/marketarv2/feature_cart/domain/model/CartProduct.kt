package com.sebastian.marketarv2.feature_cart.domain.model

import com.sebastian.marketarv2.feature_products.domain.model.Product

data class CartProduct(

    val productName: String,
    val category: String,
    val image: String,
    val unit: String,
    val quantity: Double,
    val price: Int

)

