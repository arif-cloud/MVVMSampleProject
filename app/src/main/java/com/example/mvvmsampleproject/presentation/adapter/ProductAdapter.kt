package com.example.mvvmsampleproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmsampleproject.databinding.ItemRowBinding
import com.example.mvvmsampleproject.domain.model.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private val productList : ArrayList<Product> = arrayListOf()
    inner class ProductViewHolder(private val binding : ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product : Product) {
            binding.apply {
                Glide.with(itemView.context).load(product.thumbnail).into(productImageView)
                productTitleTextView.text = product.title
                productPriceTextView.text = product.price.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    fun updateProductList(newProductList : ArrayList<Product>) {
        productList.clear()
        productList.addAll(newProductList)
        notifyDataSetChanged()
    }
}