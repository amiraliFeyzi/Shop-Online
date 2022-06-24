package com.example.shoponline.model.datasource.product

import com.example.shoponline.model.dataclass.Product

interface ProductDataSource {
    suspend fun getAmazingOffProduct():List<Product>

    suspend fun getNewProducts():List<Product>
}