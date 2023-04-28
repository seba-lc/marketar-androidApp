package com.sebastian.marketarv2.feature_orders.presentation

sealed class OrdersEvents {
    object PostOrder : OrdersEvents()
}
