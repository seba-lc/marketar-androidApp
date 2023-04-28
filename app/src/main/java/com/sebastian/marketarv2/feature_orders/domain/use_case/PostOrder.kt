package com.sebastian.marketarv2.feature_orders.domain.use_case

import com.sebastian.marketarv2.core.data.repository.MarketRepositoryImpl
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_orders.domain.model.Order
import retrofit2.Response
import javax.inject.Inject

class PostOrder @Inject constructor(
    private val repository: MarketRepositoryImpl
) {

    suspend operator fun invoke(orderPlaced: List<CartProduct>) : Response<Order> {
        return repository.postOrder(
            owner = "pruebaAndroid",
            totalPrice = 1500.00,
            orderPlaced = orderPlaced,
            orderAddress = "pruebaAndroid",
            orderDate = "pruebaAndroid",
            status = "pending",
            idMP = "pruebaAndroid"
        )
    }

}