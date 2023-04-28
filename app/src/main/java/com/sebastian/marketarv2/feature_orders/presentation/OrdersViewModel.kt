package com.sebastian.marketarv2.feature_orders.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_orders.domain.use_case.PostOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val postOrder: PostOrder
) : ViewModel() {

    private val _state = MutableStateFlow(OrdersState())
    val state: StateFlow<OrdersState> = _state


    fun onEvent(event: OrdersEvents, order: List<CartProduct>) {
        when(event) {
            is OrdersEvents.PostOrder -> {
                viewModelScope.launch {
                    try {
                        postOrder(order)
//                        _state.value = state.value.copy(
//                            orderPosted = orderPosted.body()
//                        )
                    } catch (e: IOException) {}

                }
            }

        }
    }

}