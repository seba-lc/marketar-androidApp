package com.sebastian.marketarv2.core.data.repository

import com.google.gson.Gson
import com.sebastian.marketarv2.core.data.data_source.ProductDao
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_orders.domain.model.Order
import com.sebastian.marketarv2.feature_products.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) {

    val gson = Gson()

    suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            val products = productDao.getProducts()
            products.body() ?: emptyList()
        }
    }

    suspend fun postOrder(
        owner: String,
        totalPrice: Double,
        orderPlaced: List<CartProduct>,
        orderAddress: String,
        orderDate: String,
        status: String,
        idMP: String
    ): Response<Order> {
        return productDao.postOrder(owner, totalPrice, orderPlaced.map { item -> gson.toJson(item) }, orderAddress, orderDate, status, idMP)
    }

}