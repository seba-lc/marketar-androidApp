package com.sebastian.marketarv2.feature_cart.presentation.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.domain.use_case.*
import com.sebastian.marketarv2.feature_products.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCases: CartUseCases
) : ViewModel() {

    private val _state = mutableStateOf(CartState())
    val state: State<CartState> = _state

    init {
        getCartProducts()
    }

    suspend fun onEvent(event: CartEvents, product: Product?) {
        when(event) {
            is CartEvents.AddProduct -> {
                if (product != null) cartUseCases.addProduct(product, state, _state)
            }
            is CartEvents.SubstractProduct -> {
                if (product != null) cartUseCases.substractProduct(product, state, _state)
            }
            is CartEvents.DeleteProduct -> {
                if (product != null) cartUseCases.deleteProduct(product, state, _state)
            }
            is CartEvents.DeleteCart -> {
                cartUseCases.deleteCart()
            }

        }
    }

    private fun getCartProducts() {
        cartUseCases.getProducts()
            .onEach { product ->
                println(product)
                _state.value = state.value.copy(
                    products = product.toMutableList()
                )
            }
            .launchIn(viewModelScope)
    }

}