package com.sebastian.marketarv2.feature_cart.domain.use_case

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.presentation.cart.CartState
import com.sebastian.marketarv2.feature_products.data.repository.MarketRepositoryImpl
import com.sebastian.marketarv2.feature_products.domain.model.Product
import javax.inject.Inject

class AddProduct @Inject constructor(
    private val repository: MarketRepositoryImpl //No lo uso pero me pide que injecte algo
    //Pero en el futuro lo quiero guardar en el dispositivo quizás con Room
    //Seguramente no tiene sentido hacer todo esto si no interactuo con una db. Debe de haber una forma más corta.
) {

    operator fun invoke(product: Product, state: State<CartState>, _state: MutableState<CartState>) : Unit {
        val newCartProduct = CartProduct(product.productName, product.category, product.image, product.unit, product.minUnit, product.price)
        val productExist = state.value.products.find { item ->
            item.productName == newCartProduct.productName
        }
        if(productExist != null) {
            val productEdited = productExist.copy(
                quantity = productExist.quantity + product.delta
            )
            val filteredCart = state.value.products.filter { item -> item != productExist }.toMutableList()
            filteredCart.add(filteredCart.size, productEdited)
            _state.value = state.value.copy(
                products = filteredCart
            )
        } else {
            val filteredCart = state.value.products.filter { item -> item.productName != "soloQuieroQueSeActualiceElEstado" }.toMutableList()
            filteredCart.add(state.value.products.size, newCartProduct)
            _state.value = state.value.copy(
                products = filteredCart
            )

        }

    }

}