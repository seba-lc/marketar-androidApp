package com.sebastian.marketarv2.feature_cart.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sebastian.marketarv2.feature_products.domain.model.Product
import javax.annotation.Nonnull

@Entity
data class CartProduct(


    val productName: String,
    val category: String,
    val image: String,
    val unit: String,
    val quantity: Double,
    val price: Int,
    @PrimaryKey val id: Int? = null

)

class InvalidCartProductException(message: String): Exception(message)

