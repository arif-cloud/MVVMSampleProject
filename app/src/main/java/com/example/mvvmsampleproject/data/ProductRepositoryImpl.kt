package com.example.mvvmsampleproject.data

import com.example.mvvmsampleproject.domain.model.ResponseProduct
import com.example.mvvmsampleproject.data.remote.ProductApi
import com.example.mvvmsampleproject.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api : ProductApi
) : ProductRepository {

    override suspend fun getProducts(): ResponseProduct {
        return api.getProducts()
    }

}