package com.sebastian.marketarv2.di

import com.sebastian.marketarv2.feature_products.core.Constants.Companion.BASE_URL
import com.sebastian.marketarv2.feature_products.data.data_source.ProductDao
import com.sebastian.marketarv2.feature_products.domain.repository.ProductRepository
import com.sebastian.marketarv2.feature_products.domain.use_case.GetProducts
import com.sebastian.marketarv2.feature_products.domain.use_case.ProductUseCases
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

    @Singleton
    @Provides
    fun provideProductUseCases(repository: ProductRepository) : ProductUseCases {
        return ProductUseCases(
            getProducts = GetProducts(repository)
        )
    }

}
