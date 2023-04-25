package com.sebastian.marketarv2.feature_products.domain.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebastian.marketarv2.feature_products.domain.model.util.OrderType
import com.sebastian.marketarv2.feature_products.domain.model.util.ProductOrder
import com.sebastian.marketarv2.feature_products.domain.use_case.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productUseCases: GetProducts
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsState())
    val state: StateFlow<ProductsState> = _state

    init {
        getProducts(ProductOrder.All(OrderType.Ascending))
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
                val products = productUseCases(productOrder, null)
                _state.value = state.value.copy(
                    products = products,
                    productsOrder = productOrder
                )
            } catch (_: Exception) {}
        }
    }

}