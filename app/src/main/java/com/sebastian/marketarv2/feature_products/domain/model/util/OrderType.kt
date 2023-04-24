package com.sebastian.marketarv2.feature_products.domain.model.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
