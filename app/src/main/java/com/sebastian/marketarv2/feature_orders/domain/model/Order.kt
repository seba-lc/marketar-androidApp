package com.sebastian.marketarv2.feature_orders.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import javax.annotation.Nonnull

@Entity
data class Order(

    val owner: String,
    val totalPrice: Double,
    val orderPlaced: String,
    val orderAddress: String,
    val orderDate: String,
    val status: String,
    val idMP: String,
)
