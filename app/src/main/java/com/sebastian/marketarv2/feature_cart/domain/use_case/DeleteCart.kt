package com.sebastian.marketarv2.feature_cart.domain.use_case

import com.sebastian.marketarv2.feature_cart.domain.repository.CartRepository
import javax.inject.Inject

class DeleteCart @Inject constructor(
    private val repository: CartRepository
) {

    suspend operator fun invoke() {
        repository.deleteAllProducts()
    }

}