package com.sebastian.marketarv2.feature_cart.data.repository

import com.sebastian.marketarv2.feature_cart.data.data_source.CartDao
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class CartRepositoryImpl(
    private val dao: CartDao
) : CartRepository {
        override fun getProducts(): Flow<List<CartProduct>> {
                return dao.getCartProducts()
        }

        override suspend fun addProduct(product: CartProduct) {
                return dao.addProduct(product)
        }

        override suspend fun deleteProduct(product: CartProduct) {
                return dao.deleteProduct(product)
        }

        override suspend fun deleteAllProducts() {
                return dao.deleteAllProducts()
        }

}