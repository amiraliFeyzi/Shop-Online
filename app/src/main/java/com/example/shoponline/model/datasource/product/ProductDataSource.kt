package com.example.shoponline.model.datasource.product

import com.example.shoponline.model.dataclass.ImageProduct
import com.example.shoponline.model.dataclass.Product

interface ProductDataSource {
    suspend fun getAmazingOffProduct(): List<Product>

    suspend fun getNewProducts(): List<Product>

    suspend fun getPopularDetailProduct(id: String): List<Product>

    suspend fun getDetailNewProduct(id: String): List<Product>

    suspend fun getCategoryDetailProduct(id: String): List<Product>

    suspend fun getDetailImageProduct(id: String): List<ImageProduct>

    suspend fun getSimilarProduct(categoryId: String): List<Product>

    suspend fun getCompareProduct(categoryId: String): List<Product>

}