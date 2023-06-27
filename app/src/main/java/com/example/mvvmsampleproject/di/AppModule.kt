package com.example.mvvmsampleproject.di

import com.example.mvvmsampleproject.data.remote.ProductApi
import com.example.mvvmsampleproject.domain.repository.ProductRepository
import com.example.mvvmsampleproject.data.ProductRepositoryImpl
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
    fun provideProductApi() : ProductApi {
        return Retrofit.Builder().
        baseUrl("https://dummyjson.com/").
        addConverterFactory(GsonConverterFactory.create()).
        build().
        create(ProductApi::class.java)
    }

    @Singleton
    @Provides
    fun provideProductRepository(api: ProductApi) : ProductRepository {
        return ProductRepositoryImpl(api)
    }

}