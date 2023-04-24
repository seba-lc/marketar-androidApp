package com.sebastian.marketarv2.feature_products.domain.model.util

sealed class ProductOrder (val orderType: OrderType) {
    class Category(orderType: OrderType): ProductOrder(orderType)
    class All(orderType: OrderType): ProductOrder(orderType)

    fun copy(orderType: OrderType) : ProductOrder {
        return when(this) {
            is Category -> Category(orderType)
            is All -> All(orderType)
        }
    }
}
