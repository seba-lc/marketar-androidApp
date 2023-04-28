package com.sebastian.marketarv2.feature_cart.domain.repository

import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun getProducts(): Flow<List<CartProduct>>

    suspend fun addProduct(product: CartProduct)

    suspend fun deleteProduct(product: CartProduct)

    suspend fun deleteAllProducts()

}