package com.example.shoponline.model.datasource.product

import com.example.shoponline.model.apiservice.ApiService
import com.example.shoponline.model.dataclass.Product

class ProductRemoteDataSource(private val apiService: ApiService):ProductDataSource {

    override suspend fun getAmazingOffProduct(): List<Product> =
        apiService.getAmazingOffProduct()

    override suspend fun getNewProducts(): List<Product> =
        apiService.getNewProducts()

    override suspend fun getPopularDetailProduct(id: String): List<Product> =
        apiService.getPopularDetailProduct(id)

    override suspend fun getDetailNewProduct(id: String): List<Product> =
        apiService.getDetailNewProduct(id)

    override suspend fun getCategoryDetailProduct(id: String): List<Product> =
        apiService.getCategoryDetailProduct(id)
}