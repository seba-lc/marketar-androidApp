package com.sebastian.marketarv2.feature_products.presentation.products

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebastian.marketarv2.feature_products.domain.model.util.OrderType
import com.sebastian.marketarv2.feature_products.domain.model.util.ProductOrder
import com.sebastian.marketarv2.feature_products.domain.use_case.ProductUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductsViewModel @Inject constructor(
    private val productUseCases: ProductUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsState())
    val state: StateFlow<ProductsState> get() = _state

    init {
        getProducts(ProductOrder.All(OrderType.Descending))
    }

    fun onEvent(event: ProductsEvent) {
        when(event) {
            is ProductsEvent.Order -> {
                if(state.value.productsOrder::class == event.productOrder::class &&
                        state.value.productsOrder.orderType == event.productOrder.orderType) {
                    return
                }
                getProducts(event.productOrder)
            }
            is ProductsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getProducts(productOrder: ProductOrder) {
        viewModelScope.launch {
            try {
                val products = productUseCases.getProducts(productOrder, null)
                _state.value = state.value.copy(
                    products = products,
                    productsOrder = productOrder
                )
            } catch (_: Exception) {}
        }
    }

}