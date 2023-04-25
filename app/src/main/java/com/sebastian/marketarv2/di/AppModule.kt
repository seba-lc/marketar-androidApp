package com.sebastian.marketarv2.di

import com.sebastian.marketarv2.core.util.Constants.Companion.BASE_URL
import com.sebastian.marketarv2.feature_products.data.data_source.ProductDao
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

}
