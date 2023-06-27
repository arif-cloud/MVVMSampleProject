package com.example.mvvmsampleproject.data.remote

import com.example.mvvmsampleproject.domain.model.ResponseProduct
import retrofit2.http.GET

interface ProductApi {

    @GET("products")
    suspend fun getProducts() : ResponseProduct

}