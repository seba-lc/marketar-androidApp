package com.sebastian.marketarv2.feature_cart.domain.use_case

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.presentation.cart.CartState
import com.sebastian.marketarv2.core.data.repository.MarketRepositoryImpl
import com.sebastian.marketarv2.feature_cart.data.repository.CartRepositoryImpl
import com.sebastian.marketarv2.feature_cart.domain.model.InvalidCartProductException
import com.sebastian.marketarv2.feature_cart.domain.repository.CartRepository
import com.sebastian.marketarv2.feature_products.domain.model.Product
import javax.inject.Inject

class AddProduct @Inject constructor(
    private val repository: CartRepository
) {

    @Throws(InvalidCartProductException::class) //En realidad esto sirve para hacer validaciones no las voy a hacer ahora
    suspend operator fun invoke(product: Product, state: State<CartState>, _state: MutableState<CartState>) {
        val newCartProduct = CartProduct(product.productName, product.category, product.image, product.unit, product.minUnit, product.price)
        val productExist = state.value.products.find { item ->
            item.productName == newCartProduct.productName
        }
        if(productExist != null) {
            val productEdited = productExist.copy(
                quantity = productExist.quantity + product.delta
            )
            repository.addProduct(productEdited) //Creo que la cortaria aca porque ahora voy a interactuar con la db
            val filteredCart = state.value.products.filter { item -> item != productExist }.toMutableList()
            filteredCart.add(filteredCart.size, productEdited)
            _state.value = state.value.copy(
                products = filteredCart
            )
        } else {
            repository.addProduct(newCartProduct) //aca igual
            val filteredCart = state.value.products.filter { item -> item.productName != "soloQuieroQueSeActualiceElEstado" }.toMutableList()
            filteredCart.add(state.value.products.size, newCartProduct)
            _state.value = state.value.copy(
                products = filteredCart
            )

        }

    }

}