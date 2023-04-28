package com.sebastian.marketarv2.feature_products.presentation.products

import com.sebastian.marketarv2.feature_products.domain.model.Product
import com.sebastian.marketarv2.feature_products.domain.model.util.OrderType
import com.sebastian.marketarv2.feature_products.domain.model.util.ProductOrder

data class ProductsState(
    val products: List<Product> = emptyList(),
    val productsOrder: ProductOrder = ProductOrder.All(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)