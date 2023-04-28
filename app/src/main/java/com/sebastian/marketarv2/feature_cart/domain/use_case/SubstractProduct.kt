package com.sebastian.marketarv2.feature_cart.domain.use_case

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.presentation.cart.CartState
import com.sebastian.marketarv2.core.data.repository.MarketRepositoryImpl
import com.sebastian.marketarv2.feature_cart.data.repository.CartRepositoryImpl
import com.sebastian.marketarv2.feature_cart.domain.repository.CartRepository
import com.sebastian.marketarv2.feature_products.domain.model.Product
import javax.inject.Inject

class SubstractProduct @Inject constructor(
    private val repository: CartRepository
) {

    suspend operator fun invoke(product: Product, state: State<CartState>, _state: MutableState<CartState>) {

        val productSelected = state.value.products.find { item ->
            item.productName == product.productName
        }
        val productIndex = state.value.products.indexOf(productSelected)
        if(productSelected != null) {
            val cartFiltered = state.value.products.filter { item -> item.productName != product.productName }.toMutableList()
            if(productSelected.quantity == product.minUnit) {
                _state.value = state.value.copy(
                    products = cartFiltered
                )

                repository.deleteAllProducts()
                cartFiltered.forEach { item ->
                    repository.addProduct(item)
                }

            } else {
                val newValue = CartProduct(productSelected.productName, productSelected.category, productSelected.image, productSelected.unit, productSelected.quantity - product.delta, product.price)
                cartFiltered.add(productIndex, newValue)
//                _state.value = state.value.copy(
//                    products = cartFiltered
//                )

                repository.deleteAllProducts()
                cartFiltered.forEach { item ->
                    repository.addProduct(item)
                }
            }
        }
    }
}