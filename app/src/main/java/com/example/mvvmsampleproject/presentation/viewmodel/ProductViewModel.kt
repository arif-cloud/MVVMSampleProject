package com.example.mvvmsampleproject.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmsampleproject.domain.model.Product
import com.example.mvvmsampleproject.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository : ProductRepository
) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products : LiveData<List<Product>> get() = _products

    init {
        getProductsData()
    }

    private fun getProductsData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getProducts()
            _products.postValue(response.products)
        }
    }
}