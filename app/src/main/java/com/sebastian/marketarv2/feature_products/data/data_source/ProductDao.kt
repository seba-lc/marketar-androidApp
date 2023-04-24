package com.sebastian.marketarv2.feature_products.data.data_source

import com.sebastian.marketarv2.feature_products.core.Constants.Companion.PRODUCTS_ENDPOINT
import com.sebastian.marketarv2.feature_products.domain.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductDao {

    @GET(PRODUCTS_ENDPOINT)
    suspend fun getProducts(): Response<List<Product>>

    //LUEGO VEO LOS DEMAS PEDIDOS DEL CRUD
}