package com.sebastian.marketarv2.feature_cart.data.data_source

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.sebastian.marketarv2.feature_cart.domain.model.CartProduct
import com.sebastian.marketarv2.feature_orders.domain.model.Order

@Database(
    entities = [CartProduct::class],
    version = 1
)
abstract class CartDatabase : RoomDatabase() {

    abstract val cartDao: CartDao

    companion object {
        const val DATABASE_NAME = "cart_db"
    }

}
