package com.sebastian.marketarv2.feature_products.data.repository

import com.sebastian.marketarv2.feature_products.data.data_source.ProductDao
import com.sebastian.marketarv2.feature_products.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) {

    suspend fun getProducts() : List<Product> {
        return withContext(Dispatchers.IO) {
            val products = productDao.getProducts()
            products.body() ?: emptyList()
        }
    }

}