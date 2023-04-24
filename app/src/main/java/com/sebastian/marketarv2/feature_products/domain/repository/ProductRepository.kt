package com.sebastian.marketarv2.feature_products.domain.repository

import com.sebastian.marketarv2.feature_products.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

}