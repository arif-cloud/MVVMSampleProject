package com.example.mvvmsampleproject.domain.model

data class ResponseProduct(
    val products : List<Product>,
    val total : Int,
    val skip : Int,
    val limit : Int
)
