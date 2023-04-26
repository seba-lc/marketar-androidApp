package com.sebastian.marketarv2.feature_cart.domain.use_case

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.presentation.cart.CartState
import com.sebastian.marketarv2.feature_products.data.repository.MarketRepositoryImpl
import com.sebastian.marketarv2.feature_products.domain.model.Product
import javax.inject.Inject

class SubstractProduct @Inject constructor(
    private val repository: MarketRepositoryImpl //No lo uso pero me pide que injecte algo
    //Pero en el futuro lo quiero guardar en el dispositivo quizás con Room
    //Seguramente no tiene sentido hacer todo esto si no interactuo con una db. Debe de haber una forma más corta.
) {

    operator fun invoke(product: Product, state: State<CartState>, _state: MutableState<CartState>) : Unit {

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
            } else {
                val newValue = CartProduct(productSelected.productName, productSelected.category, productSelected.image, productSelected.unit, productSelected.quantity - product.delta, product.price)
                cartFiltered.add(productIndex, newValue)
                _state.value = state.value.copy(
                    products = cartFiltered
                )
            }
        }
    }
}