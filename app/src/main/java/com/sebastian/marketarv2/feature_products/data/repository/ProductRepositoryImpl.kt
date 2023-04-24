package com.sebastian.marketarv2.feature_products.data.repository

import com.sebastian.marketarv2.feature_products.data.data_source.ProductDao
import com.sebastian.marketarv2.feature_products.domain.model.Product
import com.sebastian.marketarv2.feature_products.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRepositoryImpl(
    private val dao: ProductDao
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            val products = dao.getProducts()
            products.body() ?: emptyList()
        }

    }

}