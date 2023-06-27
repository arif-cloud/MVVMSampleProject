package com.example.mvvmsampleproject.domain.repository

import com.example.mvvmsampleproject.domain.model.ResponseProduct

interface ProductRepository {

    suspend fun getProducts() : ResponseProduct

}