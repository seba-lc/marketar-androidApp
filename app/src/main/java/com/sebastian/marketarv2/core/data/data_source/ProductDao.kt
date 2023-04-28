package com.sebastian.marketarv2.core.data.data_source

import com.sebastian.marketarv2.core.util.Constants.Companion.ORDERS_ENDPOINT
import com.sebastian.marketarv2.core.util.Constants.Companion.PRODUCTS_ENDPOINT
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_orders.domain.model.Order
import com.sebastian.marketarv2.feature_products.domain.model.Product
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductDao {

    @GET(PRODUCTS_ENDPOINT)
    suspend fun getProducts(): Response<List<Product>>

    @FormUrlEncoded
    @POST(ORDERS_ENDPOINT)
    suspend fun postOrder(
        @Field("owner") owner: String,
        @Field("totalPrice") totalPrice: Double,
        @Field("orderPlaced") orderPlaced: List<String>,
        @Field("orderAddress") orderAddress: String,
        @Field("orderDate") orderDate: String,
        @Field("status") status: String,
        @Field("idMP") idMP: String
    ): Response<Order>

    //LUEGO VEO LOS DEMAS PEDIDOS DEL CRUD
}