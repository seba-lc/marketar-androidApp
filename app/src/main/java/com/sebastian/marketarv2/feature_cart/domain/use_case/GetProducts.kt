package com.sebastian.marketarv2.feature_cart.domain.use_case

import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class GetProducts(
    private val repository: CartRepository
) {
    operator fun invoke() : Flow<List<CartProduct>> {

        return repository.getProducts()

    }

}