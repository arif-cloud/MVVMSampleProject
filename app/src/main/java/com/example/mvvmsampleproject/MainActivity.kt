package com.example.mvvmsampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.mvvmsampleproject.databinding.ActivityMainBinding
import com.example.mvvmsampleproject.presentation.adapter.ProductAdapter
import com.example.mvvmsampleproject.presentation.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val productViewModel : ProductViewModel by viewModels()
    private val productAdapter = ProductAdapter()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeLiveData()
        binding.apply {
            productRecyclerView.adapter = productAdapter
            productRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeLiveData() {
        productViewModel.products.observe(this, Observer { result ->
            productAdapter.updateProductList(ArrayList(result))
        })
    }
}