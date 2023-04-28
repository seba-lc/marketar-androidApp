package com.sebastian.marketarv2.feature_cart.data.data_source

import androidx.room.*
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cartProduct")
    fun getCartProducts(): Flow<List<CartProduct>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: CartProduct)

    @Delete
    suspend fun deleteProduct(product: CartProduct)

    @Query("DELETE FROM cartProduct")
    suspend fun deleteAllProducts()



}