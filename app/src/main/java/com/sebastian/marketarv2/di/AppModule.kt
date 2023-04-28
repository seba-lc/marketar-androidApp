package com.sebastian.marketarv2.di

import android.app.Application
import androidx.room.Room
import com.sebastian.marketarv2.core.util.Constants.Companion.BASE_URL
import com.sebastian.marketarv2.core.data.data_source.ProductDao
import com.sebastian.marketarv2.feature_cart.data.data_source.CartDatabase
import com.sebastian.marketarv2.feature_cart.data.repository.CartRepositoryImpl
import com.sebastian.marketarv2.feature_cart.domain.repository.CartRepository
import com.sebastian.marketarv2.feature_cart.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMarketRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideProductsApi(retrofit: Retrofit) : ProductDao {
        return retrofit.create(ProductDao::class.java)
    }

    @Provides
    @Singleton
    fun provideRoomDataBase(app: Application): CartDatabase {
        return Room.databaseBuilder(
            app,
            CartDatabase::class.java,
            CartDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRoomRepository(db: CartDatabase): CartRepository {
        return CartRepositoryImpl(db.cartDao)
    }

    @Provides
    @Singleton
    fun provideCartUseCases(repository: CartRepository) : CartUseCases {
        return CartUseCases(
            getProducts = GetProducts(repository),
            deleteProduct = DeleteProduct(repository),
            addProduct = AddProduct(repository),
            substractProduct = SubstractProduct(repository),
            deleteCart = DeleteCart(repository)

        )
    }

}
