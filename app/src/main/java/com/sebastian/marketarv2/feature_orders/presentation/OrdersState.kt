package com.sebastian.marketarv2.feature_orders.presentation

import com.sebastian.marketarv2.feature_orders.domain.model.Order

data class OrdersState(
    val orders: List<Order> = emptyList(),
    val orderPosted: Order? = null
)