package com.sebastian.marketarv2.feature_products.domain.presentation.products

import com.sebastian.marketarv2.feature_products.domain.model.util.ProductOrder

sealed class ProductsEvent {
    data class Order(val productOrder: ProductOrder): ProductsEvent()
    object ToggleOrderSection: ProductsEvent()
}
