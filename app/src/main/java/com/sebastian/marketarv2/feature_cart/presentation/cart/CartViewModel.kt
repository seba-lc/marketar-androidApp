package com.sebastian.marketarv2.feature_cart.presentation.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_cart.domain.use_case.AddProduct
import com.sebastian.marketarv2.feature_products.domain.model.Product
import com.sebastian.marketarv2.feature_products.domain.use_case.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val addProduct: AddProduct
) : ViewModel() {

    private val _state = mutableStateOf(CartState())
    val state: State<CartState> = _state

//    init {
//        getCartProducts()
//    }

    fun onEvent(event: CartEvents, product: Product) {
        when(event) {
            is CartEvents.AddProduct -> {
                addProduct(product, state, _state)
            }
        }
    }

//    private fun getCartProducts() {
//        viewModelScope.launch {
//
//        }
//    }

}